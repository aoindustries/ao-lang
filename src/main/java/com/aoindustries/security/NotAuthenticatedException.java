/*
 * ao-lang - Minimal Java library with no external dependencies shared by many other projects.
 * Copyright (C) 2012, 2016, 2020  AO Industries, Inc.
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
package com.aoindustries.security;

/**
 * Thrown when code that requires authentication is invoked in a context
 * that doesn't have an authenticated user.
 *
 * @author  AO Industries, Inc.
 */
public class NotAuthenticatedException extends SecurityException {

	private static final long serialVersionUID = 1L;

	public NotAuthenticatedException() {
		super();
	}

	public NotAuthenticatedException(String message) {
		super(message);
	}

	public NotAuthenticatedException(Throwable cause) {
		super(cause);
	}

	public NotAuthenticatedException(String message, Throwable cause) {
		super(message, cause);
	}
}
