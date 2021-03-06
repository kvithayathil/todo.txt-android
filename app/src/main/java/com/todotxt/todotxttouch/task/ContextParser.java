/**
 * This file is part of Todo.txt for Android, an app for managing your todo.txt file (http://todotxt.com).
 * <p>
 * Copyright (c) 2009-2013 Todo.txt for Android contributors (http://todotxt.com)
 * <p>
 * LICENSE:
 * <p>
 * Todo.txt for Android is free software: you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any
 * later version.
 * <p>
 * Todo.txt for Android is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with Todo.txt for Android. If not, see
 * <http://www.gnu.org/licenses/>.
 * <p>
 * Todo.txt for Android's source code is available at https://github.com/ginatrapani/todo.txt-android
 *
 * @author Todo.txt for Android contributors <todotxt@yahoogroups.com>
 * @license http://www.gnu.org/licenses/gpl.html
 * @copyright 2009-2013 Todo.txt for Android contributors (http://todotxt.com)
 */

package com.todotxt.todotxttouch.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ContextParser {
    private final static Pattern CONTEXT_PATTERN = Pattern.compile("(?:^|\\s)@(\\S*\\w)");
    private static final ContextParser INSTANCE = new ContextParser();

    private ContextParser() {
    }

    public static ContextParser getInstance() {
        return INSTANCE;
    }

    public List<String> parse(String inputText) {
        if (inputText == null) {
            return Collections.emptyList();
        }

        Matcher m = CONTEXT_PATTERN.matcher(inputText);
        List<String> contexts = new ArrayList<String>();

        while (m.find()) {
            String context = m.group(1);
            contexts.add(context);
        }

        return contexts;
    }
}
