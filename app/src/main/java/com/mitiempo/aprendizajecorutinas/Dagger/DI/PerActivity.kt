package com.mitiempo.aprendizajecorutinas.Dagger.DI

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class PerActivity {
}