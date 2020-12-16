/*
 * ao-lang - Minimal Java library with no external dependencies shared by many other projects.
 * Copyright (C) 2020  AO Industries, Inc.
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
package com.aoindustries.util.function;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * A consumer that is allowed to throw a checked exception.
 *
 * @see Consumer
 */
@FunctionalInterface
public interface ConsumerE<T, E extends Throwable> {

	void accept(T t) throws E;

	default ConsumerE<T, E> andThen(ConsumerE<? super T, ? extends E> after) throws E {
		Objects.requireNonNull(after);
		return (T t) -> { accept(t); after.accept(t); };
	}
}