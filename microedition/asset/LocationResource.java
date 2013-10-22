/*
 * <copyright>
 * 
 * Copyright 1997-2001 BBNT Solutions, LLC.
 * under sponsorship of the Defense Advanced Research Projects
 * Agency (DARPA).
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the Cougaar Open Source License as published by
 * DARPA on the Cougaar Open Source Website (www.cougaar.org).
 * 
 * THE COUGAAR SOFTWARE AND ANY DERIVATIVE SUPPLIED BY LICENSOR IS
 * PROVIDED "AS IS" WITHOUT WARRANTIES OF ANY KIND, WHETHER EXPRESS OR
 * IMPLIED, INCLUDING (BUT NOT LIMITED TO) ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE, AND WITHOUT
 * ANY WARRANTIES AS TO NON-INFRINGEMENT.  IN NO EVENT SHALL COPYRIGHT
 * HOLDER BE LIABLE FOR ANY DIRECT, SPECIAL, INDIRECT OR CONSEQUENTIAL
 * DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE OF DATA OR PROFITS,
 * TORTIOUS CONDUCT, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THE COUGAAR SOFTWARE.
 * </copyright>
 */

 package org.cougaar.microedition.asset;

/**
 * This resource maintains position information like that available from
 * a GPS receiver.
 */
public interface LocationResource extends Resource
{
  /**
   * Read the latitude. Negative values are south.
   * @return the current latitude.
   */
  public double getLatitude();
  /**
   * Read the longitude. Negative values are west.
   * @return the current longitude.
   */
  public double getLongitude();
  /**
   * Read the altitude.
   * @return the current altitude.
   */
  public double getAltitude();
  /**
   * Get the current heading (orientation) of the vehicle.
   */
  public double getHeading();

  /**
   * Get the last time value.
   */
  public java.util.Date getDate();

}