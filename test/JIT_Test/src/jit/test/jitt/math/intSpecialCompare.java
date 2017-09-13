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
package jit.test.jitt.math;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.Assert;

@Test(groups = { "level.sanity","component.jit" })
public class intSpecialCompare extends jit.test.jitt.Test {
	private static Logger logger = Logger.getLogger(intSpecialCompare.class);

	private static void tstFoo(int i,int j,int k) {
		
		if (i != 0)
			Assert.fail("bad math");
		if (j == 0)
			Assert.fail("bad math");
		if (k >= i)
			Assert.fail("bad math");

		if (k >= 0)
		  {
		    logger.error("\nk >= 0 failed");
			Assert.fail("bad math");
		  }
		if (i > 0)
			Assert.fail("bad math");
		if (i < 0)
			Assert.fail("bad math");
		if (j <= 0)
			Assert.fail("bad math");
		if (0 > j)
            Assert.fail("bad math");

	}

	@Test
	public void testIntSpecialCompare() {
		for (int j = 0; j < sJitThreshold; j++) {
			tstFoo(0,1,-1);
		}
}
}