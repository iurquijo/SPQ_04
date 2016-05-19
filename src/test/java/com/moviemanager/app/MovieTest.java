/**
 * 
 */
package com.moviemanager.app;

import junit.framework.JUnit4TestAdapter;
//import com.moviemanager.client.*;
import com.moviemanager.client.GraficalInterfaces.Delegate_Login;
import com.moviemanager.client.GraficalInterfaces.Delegate_Main;
import com.moviemanager.client.GraficalInterfaces.Delegate_Register;
import com.moviemanager.client.GraficalInterfaces.Login;
import com.moviemanager.client.GraficalInterfaces.Main;
import com.moviemanager.client.GraficalInterfaces.MovieWindow;
import com.moviemanager.client.GraficalInterfaces.Register;
import com.moviemanager.server.IServer;
import com.moviemanager.server.Server;
import com.moviemanager.server.DAO.*;
import com.moviemanager.server.DTO.*;
import com.moviemanager.server.jdo.*;
import com.moviemanager.server.jdo.Actor;
import com.moviemanager.server.jdo.Comment;
import com.moviemanager.server.jdo.Director;
import com.moviemanager.server.jdo.Movie;
import com.moviemanager.server.jdo.PlayList;
import com.moviemanager.server.jdo.User;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RMISecurityManager;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * RMI Unit test for Simple Client / Server RMI Testing. Testing the only the
 * Remoteness
 */
@SuppressWarnings("deprecation")
public class MovieAdvisorTest {
	// Properties are hard-coded because we want the test to be executed without
	// external interaction

	private static String cwd = MovieAdvisorTest.class.getProtectionDomain().getCodeSource().getLocation()
			.getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;

	private IServer server;
	User m;
	List<MovieDTO> t = new ArrayList<MovieDTO>();
	MovieDTO r;

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(MovieAdvisorTest.class);
	}

	@BeforeClass
	static public void setUp() {
		// Launch the RMI registry
		class RMIRegistryRunnable implements Runnable {

			public void run() {
				try {
					java.rmi.registry.LocateRegistry.createRegistry(1099);
					System.out.println("BeforeClass: RMI registry ready.");
				} catch (Exception e) {
					System.out.println("Exception starting RMI registry:");
					e.printStackTrace();
				}
			}
		}

		rmiRegistryThread = new Thread(new RMIRegistryRunnable());
		rmiRegistryThread.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		class RMIServerRunnable implements Runnable {

			public void run() {
				System.out.println(
						"This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
				System.out.println("**************: " + cwd);
				System.setProperty("java.rmi.server.codebase", "file:" + cwd);
				System.setProperty("java.security.policy", "target/test-classes/security/java.policy");

				if (System.getSecurityManager() == null) {
					System.setSecurityManager(new RMISecurityManager());
				}

				String name = "//127.0.0.1:1099/MovieManagerServer";
				System.out.println("BeforeClass - Setting the server ready TestServer name: " + name);

				try {

					IServer server = new Server();
					Naming.rebind(name, server);
				} catch (RemoteException re) {
					System.err.println(" # Messenger RemoteException: " + re.getMessage());
					re.printStackTrace();
					System.exit(-1);
				} catch (MalformedURLException murle) {
					System.err.println(" # Messenger MalformedURLException: " + murle.getMessage());
					murle.printStackTrace();
					System.exit(-1);
				}
			}
		}
		rmiServerThread = new Thread(new RMIServerRunnable());
		rmiServerThread.start();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

	@Before
	public void setUpDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			System.out.println("Deleting test users from persistence. Cleaningup.");
			Query q1 = pm.newQuery(User.class);
			long numberInstancesDeleted = q1.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted + " user");

			System.out.println("Deleting test comments from persistence. Cleaningup.");
			Query q2 = pm.newQuery(Comment.class);
			long numberInstancesDeleted2 = q2.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted2 + " comment");

			System.out.println("Deleting test movies from persistence. Cleaningup.");
			Query q3 = pm.newQuery(Movie.class);
			long numberInstancesDeleted3 = q3.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted3 + " movie");

			System.out.println("Deleting test actors from persistence. Cleaningup.");
			Query q4 = pm.newQuery(Actor.class);
			long numberInstancesDeleted4 = q4.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted4 + " actor");
			
			System.out.println("Deleting test directors from persistence. Cleaningup.");
			Query q5 = pm.newQuery(Director.class);
			long numberInstancesDeleted5 = q5.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted5 + " director");
			
			System.out.println("Deleting test actors from persistence. Cleaningup.");
			Query q6 = pm.newQuery(PlayList.class);
			long numberInstancesDeleted6 = q6.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted6 + " playist");

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		IServer server;
		try {
			server = new Server();
			((Server) server).createDatabase();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Before
	public void setUpClient() {
		try {
			System.setProperty("java.security.policy", "target/test-classes/security/java.policy");

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			String name = "//127.0.0.1:1099/MovieManagerServer";
			System.out.println("BeforeTest - Setting the client ready for calling TestServer name: " + name);
			server = (IServer) java.rmi.Naming.lookup(name);
		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
			re.printStackTrace();
			System.exit(-1);
		}

	}

	@Before
	public void setUpData() {

		m = new User("as@as","aitor", "aitor", new ArrayList<Comment>(), new ArrayList<PlayList>());
		t.add(new MovieDTO("Titanic", "8", "0", "sea", new Director(), new ArrayList<Comment>(), new ArrayList<Actor>()));

		new Comment("a", m, null);
	}

	/*
	 * @Test public void registerNewUserTest() { try{ System.out.println(
	 * "Test 1 - Register new user"); server.registerUser("ipina", "ipina"); }
	 * catch (Exception re) { System.err.println(
	 * " # Messenger RemoteException: " + re.getMessage()); }
	 * 
	 * Very simple test, inserting a valid new user
	 * 
	 * assertTrue( true ); }
	 */
	@Test
	public void getMovieByNameTest() {
		boolean test = false;
		int cont = 0;
		try {
			System.out.println("Test 2 - Get a Movie by Name");
			t = server.getMovieByName("Titanic");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */

		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getNameM()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);

	}

	@Test
	public void getMovieByRateTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 3 - Get a Movie by Rate");
			t = server.getMovieByRate("8");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		for (int i = 0; i < t.size(); i++) {
			if ("3".equals(t.get(i).getRate()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void getMovieByNameAndRateTest() {
		boolean test = false;
		int cont = 0;

		try {
			System.out.println("Test 4 - Get a Movie by Name and Rate");
			t = server.getMovieByNameAndRate("Titanic", "8");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		for (int i = 0; i < t.size(); i++) {
			if ("Foster".equals(t.get(i).getNameM()) && "8".equals(t.get(i).getRate()))
				;
			cont++;
		}
		if (cont == t.size()) {
			test = true;
		}
		assertTrue(test);
	}

	@Test
	public void setCommentTest() {
		boolean test = false;
		MovieDTO rest = new MovieDTO("Hulk", "5", "0", "heroe", new Director(), new ArrayList<Comment>(), new ArrayList<Actor>());
		System.out.println("------------------------------------------------" + test);

		try {
			System.out.println("Test 5 - set a comment");
			test = server.setComment("new comment", rest, new UserDTO(m.getNick(), m.getPassword()));
			System.out.println("------------------------------------------------" + test);
		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */

		assertTrue(test);
	}

	@Test
	public void addRateToMovieTest() {
		boolean test = false;
		List<Comment> comments = new ArrayList<Comment>();
		List<Actor> actors = new ArrayList<Actor>();

		try {
			System.out.println("Test 6 - set a rate to a movie");
			test = server.addRateToMovie(
					new MovieDTO("Name","5", "1", "Desc", new Director(), comments, actors ), "5");

		} catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		}
		/*
		 * Very simple test
		 */
		assertTrue(test);
	}

	@Test
	public void addUserTest() {
		boolean test = false;
		try {
			System.out.println("Test 15 - adda user");
			test = server.addUser("serhat", "serhat", "as@as");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Very simple test
		 */
		assertTrue(test);

	}

	@Test
	public void getMemberTest() {
		boolean test = false;
		UserDTO m = new UserDTO("aitor","aitor");
		try {
			System.out.println("Test 13 - sget a user");

			m = server.retrieveUser(this.m.getNick());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (m.getNick().equals(this.m.getNick())) {
			test = true;
		}

		/*
		 * Very simple test
		 */
		assertTrue(test);
	}

	@Test
	public void MemberDAOTest() {
		UserDTO mdto = new UserDTO("inigo", "inigo");
		mdto.getNick();
		mdto.getPassword();
		if (mdto.getNick() == "inigo") {
			assertTrue(true);
		} else
			assertTrue(false);

	}
	@Test
	public void UserDAOTest() {
		
		UserDAO udao= new UserDAO();
		udao.storeUser(new User());
		udao.retrieveUser("aitor");
		udao.updateUser(m);
		if (m.getMail() == "as@as") {
			assertTrue(true);
		} else
			assertTrue(false);
	}
	@Test
	public void MovieDAOTest() {
		MovieDTO mdto = new MovieDTO("Hulk", "5", "0", "heroe", new Director(), new ArrayList<Comment>(), new ArrayList<Actor>());
		new MovieDTO();
		Movie m = new Movie();
		m.setCommentsM(mdto.getCommentsM());
		m.setNameM(mdto.getNameM());
		m.setRate(mdto.getNumRates());
		if (mdto.getNameM().equals(r.getNameM())) {
			assertTrue(true);
		} else
			assertTrue(false);

	}
	
	@Test
	public void WindowsTest() {

		new Login();
		new Main();
		new Register();
		new MovieWindow();
		Delegate_Login dlw=new Delegate_Login("127.0.0.1", "1099", "MovieAdvisor");
		Delegate_Register dr = new Delegate_Register("127.0.0.1", "1099", "MovieAdvisor");
		new Delegate_Main("127.0.0.1", "1099", "MovieAdvisor", new UserDTO(m.getNick(), m.getPassword()));
		
		//dlw.getData();

		//		dr.getData();
	}

	@After
	public void RestoreDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			System.out.println("Deleting test user from persistence. Cleaningup.");
			Query q1 = pm.newQuery(User.class);
			long numberInstancesDeleted = q1.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted + " user");

			System.out.println("Deleting test comments from persistence. Cleaningup.");
			Query q2 = pm.newQuery(Comment.class);
			long numberInstancesDeleted2 = q2.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted2 + " comment");

			System.out.println("Deleting test movies from persistence. Cleaningup.");
			Query q3 = pm.newQuery(Movie.class);
			long numberInstancesDeleted3 = q3.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted3 + " movie");

			System.out.println("Deleting test actors from persistence. Cleaningup.");
			Query q4 = pm.newQuery(Actor.class);
			long numberInstancesDeleted4 = q4.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted4 + " actor");
			
			System.out.println("Deleting test directors from persistence. Cleaningup.");
			Query q5 = pm.newQuery(Director.class);
			long numberInstancesDeleted5 = q5.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted5 + " director");
			
			System.out.println("Deleting test actors from persistence. Cleaningup.");
			Query q6 = pm.newQuery(PlayList.class);
			long numberInstancesDeleted6 = q6.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted6 + " playist");
			
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		IServer server;
		try {
			server = new Server();
			((Server) server).createDatabase();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	static public void tearDown() {
		try {
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
