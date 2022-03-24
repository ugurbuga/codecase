package com.ugurbuga.turkcellcodecase.di.di

import android.content.Context
import androidx.room.Room
import com.ugurbuga.turkcellcodecase.dao.RoomDatabase
import com.ugurbuga.turkcellcodecase.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideProductDao(appDatabase: RoomDatabase): ProductDao {
        return appDatabase.getProductDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(
            context,
            RoomDatabase::class.java,
            "turkcell_database"
        ).build()
    }
}