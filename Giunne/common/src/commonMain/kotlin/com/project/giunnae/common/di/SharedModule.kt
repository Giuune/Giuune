package com.project.giunnae.common.di

import org.koin.core.module.Module

val sharedModule: List<Module> = listOf(
    networkModule,
    repositoryModule,
    useCaseModule,
    serviceModule,
    prefModule
)