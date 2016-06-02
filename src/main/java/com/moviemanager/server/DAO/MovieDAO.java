package com.moviemanager.server.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.moviemanager.server.DTO.*;
import com.moviemanager.server.jdo.*;

public class MovieDAO {
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	// Persistence Manager
	PersistenceManager pm = null;
	//Transaction to group DB operations
	Transaction tx = null;	

	@SuppressWarnings("finally")
	public List<MovieDTO> getMovieByName(String text) {
		List<MovieDTO> r = new ArrayList<MovieDTO>();
		try{
			
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			 tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Mov> extent = pm.getExtent(Mov.class, true);

			for (Mov movie : extent) {
				if(movie.getNameM().equals(text))
					r.add(new MovieDTO(movie.getNameM(),
							movie.getRate(),
							movie.getNumRates(),
							movie.getDescription(),
							movie.getDirector(),
							new ArrayList<Comment>(),
							new ArrayList<Actor>()));			
			}
			tx.commit();
			System.out.println("Movie retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	
	@SuppressWarnings("finally")
	public List<MovieDTO> getMovieByRate(String text) {
		List<MovieDTO> r = new ArrayList<MovieDTO>();
		try{
			
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Mov> extent = pm.getExtent(Mov.class, true);

			for (Mov movie : extent) {
				if(movie.getNameM().equals(text))
					r.add(new MovieDTO(movie.getNameM(),
							movie.getRate(),
							movie.getNumRates(),
							movie.getDescription(),
							movie.getDirector(),
							new ArrayList<Comment>(),
							new ArrayList<Actor>()));			
			}
			System.out.println(r);

			tx.commit();
			System.out.println("Movie retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public List<MovieDTO> getMovieAll() {
		List<MovieDTO> r = new ArrayList<MovieDTO>();
		try{
			
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Mov> extent = pm.getExtent(Mov.class, true);

			for (Mov movie : extent) {
					r.add(new MovieDTO(movie.getNameM(),
							movie.getRate(),
							movie.getNumRates(),
							movie.getDescription(),
							movie.getDirector(),
							new ArrayList<Comment>(),
							new ArrayList<Actor>()));			
			}
			System.out.println(r);

			tx.commit();
			System.out.println("Movie retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	
	@SuppressWarnings("finally")
	public List<MovieDTO> getMovieByNameAndRate(String text, String text1) {
		List<MovieDTO> r = new ArrayList<MovieDTO>();
		try{
			
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Mov> extent = pm.getExtent(Mov.class, true);

			for (Mov movie : extent) {
				if(movie.getNameM().equals(text))
					r.add(new MovieDTO(movie.getNameM(),
							movie.getRate(),
							movie.getNumRates(),
							movie.getDescription(),
							movie.getDirector(),
							new ArrayList<Comment>(),
							new ArrayList<Actor>()));			
			}

			tx.commit();
			System.out.println("Movie retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	
	public void createDatabase(){
		try {
			
			Mov movie1 = new Mov("Shark", "0", "0", "Shark-Description", new Drector(),new ArrayList<Comment>(),new ArrayList<Actor>());
			Mov movie2 = new Mov("Titanic", "0", "0", "Drama-Description", new Drector("Director", "DSurname", new ArrayList<Mov>()), new ArrayList<Comment>(),new ArrayList<Actor>());
			Mov movie3 = new Mov("SPQ-4", "10", "0", "AWESOME!", new Drector("YOU","ME", new ArrayList<Mov>()),new ArrayList<Comment>(),new ArrayList<Actor>());
			
			User user1 = new User("asd@asd","aitor","aitor",new ArrayList<Comment>(), new ArrayList<PlayLst>());
			User user2 = new User("asd@asd","inigo","inigo",new ArrayList<Comment>(), new ArrayList<PlayLst>());
			User user3 = new User("asd@asd","serhat","serhat",new ArrayList<Comment>(), new ArrayList<PlayLst>());
			User user4 = new User("asd@asd","george","george",new ArrayList<Comment>(), new ArrayList<PlayLst>());
			User user5 = new User("asd@asd","sergio","sergio",new ArrayList<Comment>(), new ArrayList<PlayLst>());
			
			Comment comment1 = new Comment("Awesome movie", user1, movie3);;
			Comment comment2 = new Comment("Wow", user3, movie1);
			Comment comment3 = new Comment("...", user3, movie1);
			Comment comment4 = new Comment("Nice", user4, movie2);
			Comment comment5 = new Comment("Cool", user5, movie2);
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			pm.makePersistent(movie1);
			pm.makePersistent(movie2);
			pm.makePersistent(movie3);
			
			pm.makePersistent(user1);
			pm.makePersistent(user2);
			pm.makePersistent(user3);
			pm.makePersistent(user4);
			pm.makePersistent(user5);
			
			pm.makePersistent(comment1);
			pm.makePersistent(comment2);
			pm.makePersistent(comment3);
			pm.makePersistent(comment4);
			pm.makePersistent(comment5);


			//End the transaction
			tx.commit();	
			System.out.println("Data stored ok");
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	public boolean addRateToMovie(MovieDTO movie, String newRate) {

			MovieDTO m = movie;
			Mov movieTr = null;
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

			try {
				tx.begin();
				System.out.println("   * Updating a rate: " + newRate);

				Extent<Mov> extent = pm.getExtent(Mov.class, true);
				for (Mov movieT : extent) {
					if(movieT.getNameM().toString().equals(m.getNameM().toString())){
						//					pm.deletePersistent(restaurantT);
						movieTr = movieT;
					}
				}
				movieTr.setRate((Integer.parseInt(movieTr.getRate())*Integer.parseInt(movieTr.getNumRates()) 
						+ (Integer.parseInt(newRate))) / (Integer.parseInt(movieTr.getNumRates()) + 1) +"");
				movieTr.setNumRates(Integer.parseInt(movieTr.getNumRates())+1+"");
				
				pm.makePersistent(movieTr);
				tx.commit();
			} catch (Exception ex) {
				System.out.println("Error updating a user: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}
			return true;

		}
	@SuppressWarnings("finally")
	public UserDTO retrieveUser(String nick){
		User u = new User();
		UserDTO userDTO = new UserDTO();
		try{
			
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			
			Extent<User> extent = pm.getExtent(User.class, true);
			for (User user : extent) {
				System.out.println(user.getNick());
				if(user.getNick().equals(nick)){
					
					u = user;}
			}
			
			System.out.println(u.getNick());
			System.out.println(u.getPassword());
			userDTO = new UserDTO(u.getNick(), u.getPassword());
			
			tx.commit();
			System.out.println("User retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return userDTO;
	}
	
	public boolean addUser(String nick, String password, String mail){
		
		List<Comment> commentsUser = new ArrayList<Comment>();
		List<PlayLst> playListsUser = new ArrayList<PlayLst>();
		User user = new User(mail, nick, password, commentsUser, playListsUser);
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
		       System.out.println("   * Updating a user: " + user.toString());

	    	pm.makePersistent(user);
	    	tx.commit();
	    	return true;
	     } catch (Exception ex) {
		   	System.out.println("Error updating a user: " + ex.getMessage());
		   	return false;
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
	
	public List<Comment> getAllCommentsOfMovie(MovieDTO movieDTO) {
		List<Comment> r = new ArrayList<Comment>();
		try{
			
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			
			Extent<Comment> extent = pm.getExtent(Comment.class, true);
			for (Comment comment : extent) {
				if(comment.getMovie().equals(movieDTO))
					r.add(comment);
					}

			tx.commit();
			System.out.println("M retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return r;
		}
	

	public boolean storeComment(String text, MovieDTO movie, UserDTO userDTO){
		Mov m = new Mov(movie.getNameM(),
				movie.getRate(),
				movie.getNumRates(),
				movie.getDescription(),
				movie.getDirector(),
				movie.getCommentsM(),
				movie.getActorsM());
		User u = new User();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Inserting a Comment into de Database " );
			Extent<User> extent = pm.getExtent(User.class, true);
			for (User user : extent) {
				System.out.println(user.getNick());
				if(user.getNick().equals(userDTO.getNick())){
					
					u = user;}
			}
			
			Extent<Mov> extent2 = pm.getExtent(Mov.class, true);
			for (Mov movieT : extent2) {
				if(movie.getDescription().equals(movie.getNameM())){
					m = movieT;
					System.out.println("Movie name: "+m.getNameM());
				}
			}
			Comment comment = new Comment(text, u, m);
			pm.makePersistent(comment);
			tx.commit();
			return true;
		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
			return false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
}