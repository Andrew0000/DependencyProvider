**Simple android class-instances provider**

Just put class in to SingletonContainer like that:
```
SingletonContainer.put(someObject)
```
or:
```
SingletonContainer.putForActivity(someObject, this)
```

And get instances anywhere like that:
```
SingletonContainer.get(SomeObject.class)
```

If you use **putForActivity** method, don't forget invoke:
```
SingletonContainer.handleActivityDestroy(this);
```
with Activity.onDestroy()