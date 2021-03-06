/*
 * <copyright>
 *  
 *  Copyright 1997-2012 Raytheon BBN Technologies
 *  under partial sponsorship of the Defense Advanced Research Projects
 *  Agency (DARPA).
 * 
 *  You can redistribute this software and/or modify it under the
 *  terms of the Cougaar Open Source License as published on the
 *  Cougaar Open Source Website (www.cougaar.org).
 * 
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 *  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 *  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 *  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 * </copyright>
 */

/* @generated Wed Jun 06 07:55:05 EDT 2012 from measures.def - DO NOT HAND EDIT */
/** Immutable implementation of ElectricPotential.
 **/


package org.cougaar.planning.ldm.measure;
import java.io.*;



public final class ElectricPotential extends AbstractMeasure implements Externalizable {
  // Conversion factor constants
  public static final double VOLTS_PER_MILLIVOLTS = 1000;
  public static final double MILLIVOLTS_PER_VOLTS = (1.0d/1000);

  // the value is stored as volts
  private double theValue;

  /** No-arg constructor is only for use by serialization **/
  public ElectricPotential() {}

  // private constructor
  private ElectricPotential(double v) {
    theValue = v;
  }

  /** parameterized constructor **/
  public ElectricPotential(double v, int unit) {
    if (unit >= 0 && unit <= MAXUNIT)
      theValue = v*getConvFactor(unit);
    else
      throw new UnknownUnitException();
  }

  /** takes strings of the form "Number unit" **/
  public ElectricPotential(String s) {
    int i = indexOfType(s);
    if (i < 0) throw new UnknownUnitException();
    double n = Double.valueOf(s.substring(0,i).trim()).doubleValue();
    String u = s.substring(i).trim().toLowerCase();
    if (u.equals("volts")) 
      theValue=n;
    else if (u.equals("millivolts")) 
      theValue=n*VOLTS_PER_MILLIVOLTS;
    else 
      throw new UnknownUnitException();
  }

  // TypeNamed factory methods
  public static final ElectricPotential newVolts(double v) {
    return new ElectricPotential(v);
  }
  public static final ElectricPotential newVolts(String s) {
    return new ElectricPotential((Double.valueOf(s).doubleValue()));
  }
  public static final ElectricPotential newMillivolts(double v) {
    return new ElectricPotential(v*VOLTS_PER_MILLIVOLTS);
  }
  public static final ElectricPotential newMillivolts(String s) {
    return new ElectricPotential((Double.valueOf(s).doubleValue())*VOLTS_PER_MILLIVOLTS);
  }


  public int getCommonUnit() {
    return 0;
  }

  public int getMaxUnit() { return MAXUNIT; }

  // unit names for getUnitName
  private static final String unitNames[]={
    "volts",
    "millivolts",
  };

  public String getUnitName(int unit) {
    return unitNames[unit];
  }

  // Index Typed factory methods
  static final double convFactor[]={
    1.0,
    VOLTS_PER_MILLIVOLTS,
  };

  public static final double getConvFactor(int i) { return convFactor[i]; }

  // indexes into factor array
  public static final int VOLTS = 0;
  public static final int MILLIVOLTS = 1;
  public static final int MAXUNIT = 1;

  // Index Typed factory methods
  public static final ElectricPotential newElectricPotential(double v, int unit) {
    if (unit >= 0 && unit <= MAXUNIT)
      return new ElectricPotential(v*getConvFactor(unit));
    else
      throw new UnknownUnitException();
  }

  public static final ElectricPotential newElectricPotential(String s, int unit) {
    if (unit >= 0 && unit <= MAXUNIT)
      return new ElectricPotential((Double.valueOf(s).doubleValue())*getConvFactor(unit));
    else
      throw new UnknownUnitException();
  }

  // Support for AbstractMeasure-level constructor
  public static final AbstractMeasure newMeasure(String s, int unit) {
    return newElectricPotential(s, unit);
  }
  public static final AbstractMeasure newMeasure(double v, int unit) {
    return newElectricPotential(v, unit);
  }
  // simple math : addition and subtraction
  public final Measure add(Measure toAdd) {
    if (!(toAdd instanceof ElectricPotential)) throw new IllegalArgumentException();
    return new ElectricPotential(theValue + toAdd.getNativeValue());
  }
  public final Measure subtract(Measure toSubtract) {
    if (!(toSubtract instanceof ElectricPotential)) throw new IllegalArgumentException();
    return new ElectricPotential(theValue - toSubtract.getNativeValue());
  }

  public final Measure scale(double scale) {
    return new ElectricPotential(theValue*scale,0);
  }

  public final Measure negate() {
    return newElectricPotential(-1 * theValue,0);
  }

  public final Measure floor(int unit) {
    return newElectricPotential(Math.floor(getValue(unit)),unit);
  }

  public final Measure valueOf(double value) {
    return new ElectricPotential(value);
  }

  public final Measure valueOf(double value, int unit) {
    return new ElectricPotential(value, unit);
  }

  public final double getNativeValue() {
    return theValue;
  }

  public final int getNativeUnit() {
    return 0;
  }

  public final Duration divide(Rate toRate) {
    Measure canonicalNumerator = toRate.getCanonicalNumerator();
    if (!(toRate.getCanonicalNumerator() instanceof ElectricPotential)) {
      throw new IllegalArgumentException("Expecting a ElectricPotential/Duration");
    }
    int durationNativeUnit = toRate.getCanonicalDenominator().getNativeUnit();  // seconds
    double value = toRate.getValue(canonicalNumerator.getNativeUnit(), durationNativeUnit); // ?/seconds
    return new Duration(theValue/ value,durationNativeUnit);  // ?/?/second = seconds
  }

  // Unit-based Reader methods
  public double getVolts() {
    return (theValue);
  }
  public double getMillivolts() {
    return (theValue/VOLTS_PER_MILLIVOLTS);
  }

  public double getValue(int unit) {
    if (unit >= 0 && unit <= MAXUNIT)
      return (theValue/getConvFactor(unit));
    else
      throw new UnknownUnitException();
  }

  public boolean equals(Object o) {
    return ( o instanceof ElectricPotential &&
             theValue == ((ElectricPotential) o).theValue);
  }
  public String toString() {
    return Double.toString(theValue) + "v";
  }
  public int hashCode() {
    return (new Double(theValue)).hashCode();
  }

  // serialization
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeDouble(theValue);
  }
  public void readExternal(ObjectInput in) throws IOException {
    theValue = in.readDouble();
  }
}
