package com.jarvis.cache.to;

import java.io.Serializable;

/**
 * 对缓存数据进行封装
 *
 *
 */
public class CacheWrapper<T> implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    /**
     * 缓存数据
     */
    private T cacheObject;

    /**
     * 最后加载时间
     */
    private long lastLoadTime;

    /**
     * 缓存时长
     */
    private int expire;

    public CacheWrapper() {
    }

    public CacheWrapper(T cacheObject, int expire) {
        this.cacheObject = cacheObject;
        this.lastLoadTime = System.currentTimeMillis();
        this.expire = expire;
    }

    public CacheWrapper(T cacheObject, int expire, long lastLoadTime) {
        this.cacheObject = cacheObject;
        this.lastLoadTime = lastLoadTime;
        this.expire = expire;
    }

    /**
     * 判断缓存是否已经过期
     *
     * @return boolean
     */
    public boolean isExpired() {
        if (expire > 0) {
            return (System.currentTimeMillis() - lastLoadTime) > expire * 1000;
        }
        return false;
    }

    public int getExpire() {
        return expire;
    }

    private void setCacheObject(T cacheObject) {
        this.cacheObject = cacheObject;
    }

    public long getLastLoadTime() {
        return lastLoadTime;
    }
    
    public T getCacheObject() {
        return cacheObject;
    }
    
    public void setLastLoadTime(long lastLoadTime) {
        this.lastLoadTime = lastLoadTime;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        @SuppressWarnings("unchecked")
        CacheWrapper<T> tmp = (CacheWrapper<T>) super.clone();
        tmp.setCacheObject(this.cacheObject);
        return tmp;
    }

}
