package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import net.objectof.model.Package;
import net.objectof.model.Resource;
import net.objectof.model.Transaction;
import net.objectof.model.impl.aggr.IIndexed;
import net.objectof.repo.impl.sql.ISqlDb;

import org.junit.Test;
import org.objectof.test.schema.person.Location;
import org.objectof.test.schema.person.Person;

public class JUnitTest
{
  @Test
  public void isIndexedNull()
  {
    Transaction t = repo().connect(this);
    Person person = t.create("Person");
    assertTrue("Person.locations should be null.",
        person.getLocations() == null);
  }

  @Test
  public void testIndexOfIndexed()
  {
    Transaction t = repo().connect(this);
    int j = 0;
    IIndexed<Location> locations = t.create("Person.locations");
    for (int i = 0; i < 10; i++)
    {
      Location loc = t.<Resource<Location>>create("Person.locations.location").value();
      loc.setLatitude(1.0D / (i + 1));
      loc.setLongitude((double) i);
      locations.add(loc);
    }
    try
    {
      for (Location loc : locations)
      {
        RipTest.print(t, loc);
//        RipTest.print(t, locations.get(j));
        
        assertTrue(loc.equals(locations.get(j ++)));
        
//        j ++;
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  protected Package repo()
  {
    ISqlDb db = new ISqlDb("testDatabase");
    return db.getPackage("test.objectof.org:1405/test/person");
  }
}