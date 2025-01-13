package com.project.giunne.common.di

import org.koin.core.module.Module

val sharedModule: List<Module> = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    serviceModule,
    prefModule
)