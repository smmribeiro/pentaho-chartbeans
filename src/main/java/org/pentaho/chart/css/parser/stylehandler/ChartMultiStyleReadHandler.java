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


package org.pentaho.chart.css.parser.stylehandler;

import org.pentaho.chart.css.styles.ChartMultiStyle;
import org.pentaho.reporting.libraries.css.parser.stylehandler.OneOfConstantsReadHandler;

/**
 * The style parser for the <code>-x-pentaho-chart-area-style</code> style.
 *
 * @author Ravi Hasija
 */
public class ChartMultiStyleReadHandler extends OneOfConstantsReadHandler {
  public ChartMultiStyleReadHandler() {
    super(false);
    addValue(ChartMultiStyle.MULTI);
  }
}
