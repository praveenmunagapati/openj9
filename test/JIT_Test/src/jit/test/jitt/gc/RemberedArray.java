/*******************************************************************************
 * Copyright (c) 2001, 2017 IBM Corp. and others
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] http://openjdk.java.net/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *******************************************************************************/
package jit.test.jitt.gc;

import org.testng.annotations.Test;

@Test(groups = { "level.sanity","component.jit" })
public class RemberedArray extends jit.test.jitt.Test {
    GCTestClass gcTest=null;
	
	private void tst_gcArray(int loop) {
	Object obj[] = {new RemberedArray(),new RemberedField()};
	  for (int j=0; j<loop;j++) {
       	RemberedArray localObj = new RemberedArray();
	   	obj[0] = localObj;	
	  }
	}

	@Test
	public void testRemberedArray() {
		//Scavenge x = new Scavenge();
		for (int j = 0; j <= sJitThreshold ; j++) {
			tst_gcArray(3);
		}
		

	}

}