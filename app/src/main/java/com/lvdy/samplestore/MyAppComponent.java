package com.lvdy.samplestore;


import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * 这是所有依赖的总管，activity， fragment等对应的依赖都需要在这里注册
 * 还需要依赖Androidinjectionmodule作为桥梁
 */
@Component(modules = {
        AndroidInjectionModule.class,
        MainActivityModule.class
})
public interface MyAppComponent {
    // 我日 这里一定要写自己实现的application类
    public void inject(MyApp application);
}
