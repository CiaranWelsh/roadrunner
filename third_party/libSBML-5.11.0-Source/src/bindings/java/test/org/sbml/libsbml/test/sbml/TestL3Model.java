/*
 * @file    TestL3Model.java
 * @brief   L3 Model unit tests
 *
 * @author  Akiya Jouraku (Java conversion)
 * @author  Sarah Keating 
 * 
 * ====== WARNING ===== WARNING ===== WARNING ===== WARNING ===== WARNING ======
 *
 * DO NOT EDIT THIS FILE.
 *
 * This file was generated automatically by converting the file located at
 * src/sbml/test/TestL3Model.c
 * using the conversion program dev/utilities/translateTests/translateTests.pl.
 * Any changes made here will be lost the next time the file is regenerated.
 *
 * -----------------------------------------------------------------------------
 * This file is part of libSBML.  Please visit http://sbml.org for more
 * information about SBML, and the latest version of libSBML.
 *
 * Copyright 2005-2010 California Institute of Technology.
 * Copyright 2002-2005 California Institute of Technology and
 *                     Japan Science and Technology Corporation.
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation.  A copy of the license agreement is provided
 * in the file named "LICENSE.txt" included with this software distribution
 * and also available online as http://sbml.org/software/libsbml/license.html
 * -----------------------------------------------------------------------------
 */

package org.sbml.libsbml.test.sbml;

import org.sbml.libsbml.*;

import java.io.File;
import java.lang.AssertionError;

public class TestL3Model {

  static void assertTrue(boolean condition) throws AssertionError
  {
    if (condition == true)
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      return;
    }
    else if ( (a == null) || (b == null) )
    {
      throw new AssertionError();
    }
    else if (a.equals(b))
    {
      return;
    }

    throw new AssertionError();
  }

  static void assertNotEquals(Object a, Object b) throws AssertionError
  {
    if ( (a == null) && (b == null) )
    {
      throw new AssertionError();
    }
    else if ( (a == null) || (b == null) )
    {
      return;
    }
    else if (a.equals(b))
    {
      throw new AssertionError();
    }
  }

  static void assertEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(boolean a, boolean b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertEquals(int a, int b) throws AssertionError
  {
    if ( a == b )
    {
      return;
    }
    throw new AssertionError();
  }

  static void assertNotEquals(int a, int b) throws AssertionError
  {
    if ( a != b )
    {
      return;
    }
    throw new AssertionError();
  }
  private Model M;

  protected void setUp() throws Exception
  {
    M = new  Model(3,1);
    if (M == null);
    {
    }
  }

  protected void tearDown() throws Exception
  {
    M = null;
  }

  public void test_L3_Model_NS()
  {
    assertTrue( M.getNamespaces() != null );
    assertTrue( M.getNamespaces().getLength() == 1 );
    assertTrue(M.getNamespaces().getURI(0).equals(    "http://www.sbml.org/sbml/level3/version1/core"));
  }

  public void test_L3_Model_areaUnits()
  {
    String units =  "mole";
    assertEquals( false, M.isSetAreaUnits() );
    M.setAreaUnits(units);
    assertTrue(M.getAreaUnits().equals(units));
    assertEquals( true, M.isSetAreaUnits() );
    if (M.getAreaUnits() == units);
    {
    }
    M.unsetAreaUnits();
    assertEquals( false, M.isSetAreaUnits() );
    if (M.getAreaUnits() != null);
    {
    }
  }

  public void test_L3_Model_conversionFactor()
  {
    String units =  "mole";
    assertEquals( false, M.isSetConversionFactor() );
    M.setConversionFactor(units);
    assertTrue(M.getConversionFactor().equals(units));
    assertEquals( true, M.isSetConversionFactor() );
    if (M.getConversionFactor() == units);
    {
    }
    M.unsetConversionFactor();
    assertEquals( false, M.isSetConversionFactor() );
    if (M.getConversionFactor() != null);
    {
    }
  }

  public void test_L3_Model_create()
  {
    assertTrue( M.getTypeCode() == libsbml.SBML_MODEL );
    assertTrue( M.getMetaId().equals("") == true );
    assertTrue( M.getNotes() == null );
    assertTrue( M.getAnnotation() == null );
    assertTrue( M.getId().equals("") == true );
    assertTrue( M.getName().equals("") == true );
    assertTrue( M.getSubstanceUnits().equals("") == true );
    assertTrue( M.getTimeUnits().equals("") == true );
    assertTrue( M.getVolumeUnits().equals("") == true );
    assertTrue( M.getAreaUnits().equals("") == true );
    assertTrue( M.getLengthUnits().equals("") == true );
    assertTrue( M.getConversionFactor().equals("") == true );
    assertEquals( false, M.isSetId() );
    assertEquals( false, M.isSetName() );
    assertEquals( false, M.isSetSubstanceUnits() );
    assertEquals( false, M.isSetTimeUnits() );
    assertEquals( false, M.isSetVolumeUnits() );
    assertEquals( false, M.isSetAreaUnits() );
    assertEquals( false, M.isSetLengthUnits() );
    assertEquals( false, M.isSetConversionFactor() );
  }

  public void test_L3_Model_createWithNS()
  {
    XMLNamespaces xmlns = new  XMLNamespaces();
    xmlns.add( "http://www.sbml.org", "testsbml");
    SBMLNamespaces sbmlns = new  SBMLNamespaces(3,1);
    sbmlns.addNamespaces(xmlns);
    Model m = new  Model(sbmlns);
    assertTrue( m.getTypeCode() == libsbml.SBML_MODEL );
    assertTrue( m.getMetaId().equals("") == true );
    assertTrue( m.getNotes() == null );
    assertTrue( m.getAnnotation() == null );
    assertTrue( m.getLevel() == 3 );
    assertTrue( m.getVersion() == 1 );
    assertTrue( m.getNamespaces() != null );
    assertTrue( m.getNamespaces().getLength() == 2 );
    assertTrue( m.getId().equals("") == true );
    assertTrue( m.getName().equals("") == true );
    assertTrue( m.getSubstanceUnits().equals("") == true );
    assertTrue( m.getTimeUnits().equals("") == true );
    assertTrue( m.getVolumeUnits().equals("") == true );
    assertTrue( m.getAreaUnits().equals("") == true );
    assertTrue( m.getLengthUnits().equals("") == true );
    assertTrue( m.getConversionFactor().equals("") == true );
    assertEquals( false, m.isSetId() );
    assertEquals( false, m.isSetName() );
    assertEquals( false, m.isSetSubstanceUnits() );
    assertEquals( false, m.isSetTimeUnits() );
    assertEquals( false, m.isSetVolumeUnits() );
    assertEquals( false, m.isSetAreaUnits() );
    assertEquals( false, m.isSetLengthUnits() );
    assertEquals( false, m.isSetConversionFactor() );
    m = null;
  }

  public void test_L3_Model_extentUnits()
  {
    String units =  "mole";
    assertEquals( false, M.isSetExtentUnits() );
    M.setExtentUnits(units);
    assertTrue(M.getExtentUnits().equals(units));
    assertEquals( true, M.isSetExtentUnits() );
    if (M.getExtentUnits() == units);
    {
    }
    M.unsetExtentUnits();
    assertEquals( false, M.isSetExtentUnits() );
    if (M.getExtentUnits() != null);
    {
    }
  }

  public void test_L3_Model_free_NULL()
  {
  }

  public void test_L3_Model_id()
  {
    String id =  "mitochondria";
    assertEquals( false, M.isSetId() );
    M.setId(id);
    assertTrue(M.getId().equals(id));
    assertEquals( true, M.isSetId() );
    if (M.getId() == id);
    {
    }
    M.unsetId();
    assertEquals( false, M.isSetId() );
    if (M.getId() != null);
    {
    }
  }

  public void test_L3_Model_lengthUnits()
  {
    String units =  "mole";
    assertEquals( false, M.isSetLengthUnits() );
    M.setLengthUnits(units);
    assertTrue(M.getLengthUnits().equals(units));
    assertEquals( true, M.isSetLengthUnits() );
    if (M.getLengthUnits() == units);
    {
    }
    M.unsetLengthUnits();
    assertEquals( false, M.isSetLengthUnits() );
    if (M.getLengthUnits() != null);
    {
    }
  }

  public void test_L3_Model_name()
  {
    String name =  "My_Favorite_Factory";
    assertEquals( false, M.isSetName() );
    M.setName(name);
    assertTrue(M.getName().equals(name));
    assertEquals( true, M.isSetName() );
    if (M.getName() == name);
    {
    }
    M.unsetName();
    assertEquals( false, M.isSetName() );
    if (M.getName() != null);
    {
    }
  }

  public void test_L3_Model_substanceUnits()
  {
    String units =  "mole";
    assertEquals( false, M.isSetSubstanceUnits() );
    M.setSubstanceUnits(units);
    assertTrue(M.getSubstanceUnits().equals(units));
    assertEquals( true, M.isSetSubstanceUnits() );
    if (M.getSubstanceUnits() == units);
    {
    }
    M.unsetSubstanceUnits();
    assertEquals( false, M.isSetSubstanceUnits() );
    if (M.getSubstanceUnits() != null);
    {
    }
  }

  public void test_L3_Model_timeUnits()
  {
    String units =  "mole";
    assertEquals( false, M.isSetTimeUnits() );
    M.setTimeUnits(units);
    assertTrue(M.getTimeUnits().equals(units));
    assertEquals( true, M.isSetTimeUnits() );
    if (M.getTimeUnits() == units);
    {
    }
    M.unsetTimeUnits();
    assertEquals( false, M.isSetTimeUnits() );
    if (M.getTimeUnits() != null);
    {
    }
  }

  public void test_L3_Model_volumeUnits()
  {
    String units =  "mole";
    assertEquals( false, M.isSetVolumeUnits() );
    M.setVolumeUnits(units);
    assertTrue(M.getVolumeUnits().equals(units));
    assertEquals( true, M.isSetVolumeUnits() );
    if (M.getVolumeUnits() == units);
    {
    }
    M.unsetVolumeUnits();
    assertEquals( false, M.isSetVolumeUnits() );
    if (M.getVolumeUnits() != null);
    {
    }
  }

  /**
   * Loads the SWIG-generated libSBML Java module when this class is
   * loaded, or reports a sensible diagnostic message about why it failed.
   */
  static
  {
    String varname;
    String shlibname;

    if (System.getProperty("mrj.version") != null)
    {
      varname = "DYLD_LIBRARY_PATH";    // We're on a Mac.
      shlibname = "libsbmlj.jnilib and/or libsbml.dylib";
    }
    else
    {
      varname = "LD_LIBRARY_PATH";      // We're not on a Mac.
      shlibname = "libsbmlj.so and/or libsbml.so";
    }

    try
    {
      System.loadLibrary("sbmlj");
      // For extra safety, check that the jar file is in the classpath.
      Class.forName("org.sbml.libsbml.libsbml");
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
      System.err.println("Could not load the libSBML library files due to a"+
                         " security exception.\n");
      System.exit(1);
    }
    catch (UnsatisfiedLinkError e)
    {
      e.printStackTrace();
      System.err.println("Error: could not link with the libSBML library files."+
                         " It is likely\nyour " + varname +
                         " environment variable does not include the directories\n"+
                         "containing the " + shlibname + " library files.\n");
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.err.println("Error: unable to load the file libsbmlj.jar."+
                         " It is likely\nyour -classpath option and CLASSPATH" +
                         " environment variable\n"+
                         "do not include the path to libsbmlj.jar.\n");
      System.exit(1);
    }
  }
}