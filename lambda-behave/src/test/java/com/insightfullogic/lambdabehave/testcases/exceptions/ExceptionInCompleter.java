package com.insightfullogic.lambdabehave.testcases.exceptions;

import com.insightfullogic.lambdabehave.expectations.Expect;

import java.util.function.Consumer;

import static com.insightfullogic.lambdabehave.Suite.describe;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ExceptionInCompleter {

    public static final Runnable initializer = mock(Runnable.class);
    public static final Runnable setup = mock(Runnable.class);
    public static final Consumer<Expect> spec1 = mock(Consumer.class);
    public static final Consumer<Expect> spec2 = mock(Consumer.class);
    public static final Runnable tearDown = mock(Runnable.class);
    public static final Runnable completer = mock(Runnable.class);

{
    doThrow(RuntimeException.class).when(completer).run();

    describe("a two spec suite", it -> {
        it.should("have spec1", spec1::accept);
        it.should("have spec2", spec2::accept);

        it.shouldTearDown(tearDown::run);
        it.shouldSetup(setup::run);

        it.shouldComplete(completer::run);
        it.shouldInitialize(initializer::run);
    });
}}
