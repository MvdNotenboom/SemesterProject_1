package nucleus;

import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

/**
 * Class for writing and reading from a file(.bin)
 * @author Group6
 * @version 1.1.0
 */
public class FileIO
{
   /**
    * Writes the given object to a file with the given file name
    * @param fileName
    * @param obj
    * @throws FileNotFoundException
    * @throws IOException
    */
   public void writeToFile(String fileName, Object obj) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;
      
      try
      {
         FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutputStream);
         
         writeToFile.writeObject(obj);
      }
      finally
      {
         if(writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch(IOException e)
            {
               System.out.println("IO Error closing file" + fileName);
            }
         }
      }
   }
   
   /**
    * Writes the objects in a given array to a file with a given name
    * @param fileName
    * @param objs
    * @throws FileNotFoundException
    * @throws IOException
    */
   public void writeToFile(String fileName, Object[] objs) throws FileNotFoundException, IOException
   {
      ObjectOutputStream writeToFile = null;
      
      try
      {
         FileOutputStream fileOutputStream = new FileOutputStream(fileName);
         writeToFile = new ObjectOutputStream(fileOutputStream);
         
         for(int i = 0; i < objs.length; i++)
         {
            writeToFile.writeObject(objs[i]);
         }
      }
      finally
      {
         if(writeToFile != null)
         {
            try
            {
               writeToFile.close();
            }
            catch(IOException e)
            {
               System.out.println("IO Error closing file" + fileName);
            }
         }
      }
   }
   
   /**
    * Reads the first object from the file with the given file name and returns it
    * Needs to be casted from type Object to the real object type
    * @param fileName
    * @return Object
    * @throws FileNotFoundException
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public Object readObjectFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      Object obj = null;
      ObjectInputStream readFromFile = null;
      
      try
      {
         FileInputStream fileInputStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInputStream);
         
         try
         {
            obj = readFromFile.readObject();
         }
         catch(EOFException eof)
         {
            System.out.println("Done writing");
         }
      }
      finally
      {
         if(readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch(IOException e)
            {
               System.out.println("IO Error closing file" + fileName);
            }
         }
      }
      return obj;
   }
   
   /**
    * Reads all the objects from the file with the given name and returns it as an array of Object
    * Needs to be casted from the type Object to the real type of the object
    * @param fileName
    * @return Array of Object (Object[])
    * @throws FileNotFoundException
    * @throws IOException
    * @throws ClassNotFoundException
    */
   public Object[] readArrayFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
   {
      ArrayList<Object> objs = new ArrayList<Object>();
      ObjectInputStream readFromFile = null;
      
      try
      {
         FileInputStream fileInputStream = new FileInputStream(fileName);
         readFromFile = new ObjectInputStream(fileInputStream);
         while(true)
         {
            try
            {
               objs.add(readFromFile.readObject());
            }
            catch(EOFException eof)
            {
               System.out.println("Done Writing");
               break; 
            }
         }
      }
      finally
      {
         if(readFromFile != null)
         {
            try
            {
               readFromFile.close();
            }
            catch(IOException e)
            {
               System.out.println("IO Error closing file " + fileName);
            }
         }
      }
      return objs.toArray();
   }  
}
