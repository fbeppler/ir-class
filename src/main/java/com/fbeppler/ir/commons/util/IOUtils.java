package com.fbeppler.ir.commons.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class IOUtils {

	private IOUtils() {

	}

	public static String readFromConsole(final String mensage) throws IOException {
		System.out.print(mensage);
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		return bufferRead.readLine();
	}

	public static String fromPathToString(final Path path) throws IOException {
		return Files.readAllLines(path, StandardCharsets.UTF_8).stream().collect(Collectors.joining(" "));
	}

	public static List<Path> listTxtFiles(final String folderPath) throws IOException {
		return Files.list(Paths.get(folderPath)).filter(p -> p.toFile().toString().endsWith("txt"))
				.collect(Collectors.toList());
	}

	public static Set<String> stopwords() {
		try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
				IOUtils.class.getResourceAsStream("/stopwords-pt.txt"), StandardCharsets.UTF_8))) {

			final Set<String> stopwords = new HashSet<>();
			String line;
			while ((line = reader.readLine()) != null) {
				stopwords.add(TextUtils.removeAccents(line.toLowerCase().trim()));
			}
			return stopwords;

		} catch (final IOException e) {
			throw new IllegalStateException("Can't load stopwords from file");
		}
	}

}
