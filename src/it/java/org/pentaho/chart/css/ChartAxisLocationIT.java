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


package org.pentaho.chart.css;

import junit.framework.TestCase;

import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.chart.ChartBoot;
import org.pentaho.chart.ChartDocumentContext;
import org.pentaho.chart.ChartFactory;
import org.pentaho.chart.core.ChartDocument;
import org.pentaho.chart.core.ChartElement;
import org.pentaho.chart.css.keys.ChartStyleKeys;
import org.pentaho.chart.css.styles.ChartAxisLocationType;
import org.pentaho.reporting.libraries.css.dom.LayoutStyle;
import org.pentaho.reporting.libraries.css.values.CSSValue;

public class ChartAxisLocationIT extends TestCase {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    
    // Boot the charting library - required for parsing configuration
    ChartBoot.getInstance().start();
  }
  
  public void testChartAxisType() throws IllegalStateException, ResourceException {
    final ChartDocumentContext cdc = ChartFactory.generateChart(getClass().getResource("ChartAxisLocationTest.xml")); //$NON-NLS-1$
    final ChartDocument cd = cdc.getChartDocument();
    assertNotNull(cd);
    final ChartElement element = cd.getRootElement();
    assertNotNull(element);

    final CSSValue[] passValues = new CSSValue[] {
        ChartAxisLocationType.PRIMARY, 
        ChartAxisLocationType.SECONDARY,
        ChartAxisLocationType.PRIMARY, 
        ChartAxisLocationType.PRIMARY, 
    };
    
    int counter = 0;
    final int lenArray = passValues.length;
    ChartElement child = element.getFirstChildItem();
    
    while(child != null) {
      final LayoutStyle layoutStyle = child.getLayoutStyle();
      assertNotNull(layoutStyle);
      System.out.print("Counter#: " + counter + " Expecting: " + passValues[counter]); //$NON-NLS-1$ //$NON-NLS-2$ 
      System.out.println(" -- Got: " + layoutStyle.getValue(ChartStyleKeys.AXIS_LOCATION)); //$NON-NLS-1$  
      assertEquals("Counter# " + counter + " Location: ", passValues[counter], layoutStyle.getValue(ChartStyleKeys.AXIS_LOCATION)); //$NON-NLS-1$ //$NON-NLS-2$ 
      
      child = child.getNextItem();
      counter++;
    }

    if (counter < lenArray-1) {
      throw new IllegalStateException("Not all tests covered!");  //$NON-NLS-1$
    }
  }
}
