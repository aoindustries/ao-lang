/*
 * ao-lang - Minimal Java library with no external dependencies shared by many other projects.
 * Copyright (C) 2015, 2016, 2020, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-lang.
 *
 * ao-lang is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-lang is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-lang.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoapps.lang;

import java.security.SecureRandom;
import java.util.Random;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author  AO Industries, Inc.
 */
public class StringsTest extends TestCase {

	public StringsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(StringsTest.class);
	}

	private static final Random random = new SecureRandom();

	public void testConvertToFromHexInt() {
		for(int i=0; i<1000; i++) {
			int before = random.nextInt();
			@SuppressWarnings("deprecation")
			int after = Strings.convertIntArrayFromHex(Strings.convertToHex(before).toCharArray());
			assertEquals(before, after);
		}
	}

	public void testConvertToFromHexLong() {
		for(int i=0; i<1000; i++) {
			long before = random.nextLong();
			@SuppressWarnings("deprecation")
			long after = Strings.convertLongArrayFromHex(Strings.convertToHex(before).toCharArray());
			assertEquals(before, after);
		}
	}
}
