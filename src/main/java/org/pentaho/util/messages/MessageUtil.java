/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/


package org.pentaho.util.messages;

/*
 * This program is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software 
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this 
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html 
 * or from the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright 2008 - 2017 Hitachi Vantara.  All rights reserved.
 */
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageUtil {
  private MessageUtil() {
  }

  /**
   * Get a formatted error message. The message consists of two parts. The first part is the
   * error numeric Id associated with the key used to identify the message in the resource file.
   * For instance, suppose the error key is MyClass.ERROR_0068_TEST_ERROR. The first
   * part of the error msg would be "0068". The second part of the returned string
   * is simply the <code>msg</code> parameter.
   * 
   * Currently the format is:
   * error key - error msg
   * For instance:
   * "0068 - A test error message."
   * 
   * @param key String containing the key that was used to obtain the <code>msg</code> parameter
   * from the resource file.
   * @param msg String containing the message that was obtained from the resource file using
   * the <code>key</code> parameter.
   * @return String containing the formatted error message.
   */
  public static String formatErrorMessage(final String key, final String msg) {
    int end = key.indexOf(".ERROR_"); //$NON-NLS-1$
    end = (end < 0) ? key.length() : Math.min(end + ".ERROR_0000".length(), key.length()); //$NON-NLS-1$
    return Messages.getString("MESSUTIL.ERROR_FORMAT_MASK", key.substring(0, end), msg); //$NON-NLS-1$
  }

  /**
   * Get the message from the specified resource bundle using the specified key.
   * 
   * @param bundle ResourceBundle containing the desired String
   * @param key String containing the key to locate the desired String in the ResourceBundle.
   * @return String containing the message from the specified resource bundle accessed
   * using the specified key
   */
  public static String getString(final ResourceBundle bundle, final String key) {
    try {
      return bundle.getString(key);
    } catch (Exception e) {
      return '!' + key + '!';
    }
  }

  /**
   * Get a message from the specified resource bundle using the specified key,
   * and format it. see <code>formatErrorMessage</code> for details on how the
   * message is formatted.
   * 
   * @param bundle ResourceBundle containing the desired String
   * @param key String containing the key to locate the desired String in the ResourceBundle.
   * @return String containing the formatted message.
   */
  public static String getErrorString(final ResourceBundle bundle, final String key) {
    return MessageUtil.formatErrorMessage(key, MessageUtil.getString(bundle, key));
  }

  public static String getString(final ResourceBundle bundle, final String key, final String param1) {
    try {
      final Object[] args = { param1 };
      return MessageFormat.format(bundle.getString(key), args);
    } catch (Exception e) {
      return '!' + key + '!';
    }
  }

  public static String getErrorString(final ResourceBundle bundle, final String key, final String param1) {
    return MessageUtil.formatErrorMessage(key, MessageUtil.getString(bundle, key, param1));
  }

  public static String getString(final ResourceBundle bundle, final String key, final String param1, final String param2) {
    try {
      final Object[] args = { param1, param2 };
      return MessageFormat.format(bundle.getString(key), args);
    } catch (Exception e) {
      return '!' + key + '!';
    }
  }

  public static String getErrorString(final ResourceBundle bundle, final String key, final String param1, final String param2) {
    return MessageUtil.formatErrorMessage(key, MessageUtil.getString(bundle, key, param1, param2));
  }

  public static String getString(final ResourceBundle bundle, final String key, final String param1, final String param2, final String param3) {
    try {
      final Object[] args = { param1, param2, param3 };
      return MessageFormat.format(bundle.getString(key), args);
    } catch (Exception e) {
      return '!' + key + '!';
    }
  }

  public static String getErrorString(final ResourceBundle bundle, final String key, final String param1, final String param2, final String param3) {
    return MessageUtil.formatErrorMessage(key, MessageUtil.getString(bundle, key, param1, param2, param3));
  }

  public static String getString(final ResourceBundle bundle, final String key, final String param1, final String param2, final String param3,
      final String param4) {
    try {
      final Object[] args = { param1, param2, param3, param4 };
      return MessageFormat.format(bundle.getString(key), args);
    } catch (Exception e) {
      return '!' + key + '!';
    }
  }

  public static String getErrorString(final ResourceBundle bundle, final String key, final String param1, final String param2, final String param3,
      final String param4) {
    return MessageUtil.formatErrorMessage(key, MessageUtil.getString(bundle, key, param1, param2, param3, param4));
  }

  public static String formatMessage(final String pattern, final String param1) {
    try {
      final Object[] args = { param1 };
      return MessageFormat.format(pattern, args);
    } catch (Exception e) {
      return '!' + pattern + '!';
    }
  }

  public static String formatMessage(final String pattern, final String param1, final String param2) {
    try {
      final Object[] args = { param1, param2 };
      return MessageFormat.format(pattern, args);
    } catch (Exception e) {
      return '!' + pattern + '!';
    }

  }

  public static String formatMessage(final String pattern, final String param1, final String param2, final String param3) {
    try {
      final Object[] args = { param1, param2, param3 };
      return MessageFormat.format(pattern, args);
    } catch (Exception e) {
      return '!' + pattern + '!';
    }
  }

  public static String formatMessage(final String pattern, final String param1, final String param2, final String param3, final String param4) {
    try {
      final Object[] args = { param1, param2, param3, param4 };
      return MessageFormat.format(pattern, args);
    } catch (Exception e) {
      return '!' + pattern + '!';
    }
  }
}
