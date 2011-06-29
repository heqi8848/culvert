/**
 * Copyright 2011 Booz Allen Hamilton.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Booz Allen Hamilton licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bah.culvert.inmemory;


public class InMemoryFamily extends SubMap<InMemoryQualifier> {

  public InMemoryFamily() {
    super(new Bytes("families".getBytes()));
  }

  public void put(byte[] cf, byte[] cq, long timestamp, byte[] value) {
    Bytes family = new Bytes(cf);
    InMemoryQualifier qual = super.map.get(family);
    if(qual == null)
    {
      qual = new InMemoryQualifier();
      super.map.put(family, qual);
    }
    qual.put(new Bytes(cq), new InMemoryTimestampedValue(value, timestamp));
  }

}
