package com.watchservices;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

@FunctionalInterface
interface FileVisit<T> {
	public void visit(T t);
}

public class SimpleFileVisitor<T> implements FileVisitor<T> {

	FileVisit<T> visit;

	public SimpleFileVisitor(FileVisit<T> visit) {
		this.visit = visit;
	}

	

	@Override
	public FileVisitResult preVisitDirectory(T dir, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVisitResult visitFile(T file, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVisitResult visitFileFailed(T file, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileVisitResult postVisitDirectory(T dir, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}