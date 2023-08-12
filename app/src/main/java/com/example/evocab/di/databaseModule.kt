package com.example.evocab.di

import android.content.Context
import androidx.room.Room
import com.example.evocab.data.database.DataBaseLocal
import org.koin.dsl.module


val databaseModule = module {
    single { provideLocalDatabase(get()) }

}

private fun provideLocalDatabase(context: Context): DataBaseLocal {
    return Room.databaseBuilder(
        context.applicationContext,
        DataBaseLocal::class.java,
        DataBaseLocal.NAME
    ).build()
}