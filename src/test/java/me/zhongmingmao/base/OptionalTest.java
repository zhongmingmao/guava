package me.zhongmingmao.base;

import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static junit.framework.TestCase.*;

@Slf4j
public class OptionalTest {

    @Test
    public void ofTest() {
        Integer value = 5;
        Optional<Integer> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
        log.info("isPresent={}", optional.isPresent());
        log.info("value={}", optional.get());
    }

    @Test(expected = IllegalStateException.class)
    public void absentTest() {
        int defaultValue = 0;
        Object object = Optional.absent().or(defaultValue);
        assertEquals(object, defaultValue);

        Optional<Object> absent = Optional.absent();
        assertFalse(absent.isPresent());
        log.info("value={}", absent.get());
    }

    @Test
    public void fromNullTest() {
        int defaultValue = 0;
        Object object = Optional.fromNullable(null).or(defaultValue);
        assertEquals(object, defaultValue);

        object = Optional.fromNullable(null).orNull();
        assertNull(object);
    }

    @Test
    public void asSetTest() {
        int value = 0;
        assertEquals(1, Optional.of(value).asSet().size());
        assertEquals(0, Optional.absent().asSet().size());

    }
}