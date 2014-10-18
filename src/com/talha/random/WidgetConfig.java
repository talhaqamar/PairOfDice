/***
  Copyright (c) 2008-2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  From _The Busy Coder's Guide to Advanced Android Development_
    http://commonsware.com/AdvAndroid
*/

   
package com.talha.random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.talha.random.R;

public class WidgetConfig extends AppWidgetProvider {
  
  
  @Override
  public void onUpdate(Context ctxt, AppWidgetManager mgr,
                        int[] appWidgetIds) {
    ComponentName me=new ComponentName(ctxt, WidgetConfig.class);
      
    mgr.updateAppWidget(me, buildUpdate(ctxt, appWidgetIds));
  }
  
  private RemoteViews buildUpdate(Context ctxt, int[] appWidgetIds) {
    RemoteViews updateViews=new RemoteViews(ctxt.getPackageName(),
                                            R.layout.widget);
  
    Intent i=new Intent(ctxt, WidgetConfig.class);
    
    i.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
    i.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
    
    PendingIntent pi=PendingIntent.getBroadcast(ctxt, 0 , i,
                                                PendingIntent.FLAG_UPDATE_CURRENT);
  //  CharSequence c = (CharSequence)((int)Math.random()*6);
    int v = (int)(Math.random()*6);
    String rs = Integer.toString(v);
    CharSequence cs = rs.subSequence(0, 1);
    
    
    updateViews.setTextViewText(R.id.textView1,cs); 
    updateViews.setOnClickPendingIntent(R.id.textView1, pi);
    
    updateViews.setOnClickPendingIntent(R.id.background, pi);
    
    return(updateViews);
  }
}