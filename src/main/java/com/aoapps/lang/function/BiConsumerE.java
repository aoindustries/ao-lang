/*
 * ao-lang - Minimal Java library with no external dependencies shared by many other projects.
 * Copyright (C) 2021  AO Industries, Inc.
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
package com.aoapps.lang.function;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * A biconsumer that is allowed to throw a checked exception.
 *
 * @param  <Ex>  An arbitrary exception type that may be thrown
 *
 * @see BiConsumer
 */
@FunctionalInterface
public interface BiConsumerE<T, U, Ex extends Throwable> {

	void accept(T t, U u) throws Ex;

	default BiConsumerE<T, U, Ex> andThen(BiConsumerE<? super T, ? super U, ? extends Ex> after) throws Ex {
		Objects.requireNonNull(after);

		return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
	}
}