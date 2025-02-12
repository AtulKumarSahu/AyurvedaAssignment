package com.example.ayurvedaassignment.di

import android.app.Application
import androidx.room.Room
import com.example.ayurvedaassignment.data.database.CartDatabase
import com.example.ayurvedaassignment.data.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule{
    @Provides
    @Singleton
    fun provideDatabase(app: Application):CartDatabase{
        return Room.databaseBuilder(
            app,
            CartDatabase::class.java,
            "cart_db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideRepo(database: CartDatabase): Repo {
        return Repo(database)
    }

}