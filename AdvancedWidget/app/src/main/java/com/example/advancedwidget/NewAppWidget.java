package com.example.advancedwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

            final int nrOfWidgets = appWidgetIds.length;

            for(Integer i = 0; i<nrOfWidgets; i++){
                int appWidgetId = appWidgetIds[1];
                Intent intent = new Intent(context,NewsService.class);
                intent.putExtra("appWidgetID",appWidgetId);
                context.startService(intent);

            }

    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

