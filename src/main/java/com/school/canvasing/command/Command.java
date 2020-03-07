package com.school.canvasing.command;

public interface Command<E, T> {

	public T execute(E request);

}