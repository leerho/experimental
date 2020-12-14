/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.datasketches.panama;

import org.testng.annotations.Test;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

/**
 * blah
 */
public class PlayTest {

  /**
   * blah
   */
  @Test
  public static void checkMemorySegment() {
    try (MemorySegment seg = MemorySegment.allocateNative(4 * 64)) {
      MemoryAddress adr = seg.address();
      long longAdr = adr.toRawLongValue();
      println("" + longAdr);
    }
  }

  /**
   * @param args blah
   */
  public static void main(String[] args) {
    PlayTest.checkMemorySegment();
  }

  static void println(Object o) { System.out.println(o); }
}