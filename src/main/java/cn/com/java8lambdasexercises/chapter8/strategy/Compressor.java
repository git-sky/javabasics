package cn.com.java8lambdasexercises.chapter8.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;


/**
 * 策略模式
 */
public class Compressor {

    private final CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outStream));
        }
    }


    public static void classBasedExample(Path inFile, File outFile) throws IOException {
        Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
        gzipCompressor.compress(inFile, outFile);

        Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
        zipCompressor.compress(inFile, outFile);
    }


    /**
     * 使用 Lambda 表达式或者方法引用可以去掉样板代码。在 这里，我们可以去掉具体的策略实现，
     * 使用一个方法实现算法，这里的算法由构造函数 中对应的 OutputStream 实现。
     * 使用这种方式，可以完全舍弃 GzipCompressionStrategy 和 ZipCompressionStrategy 类。
     *
     * @param inFile
     * @param outFile
     * @throws IOException
     */
    public static void lambdaBasedExample(Path inFile, File outFile) throws IOException {
        Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(inFile, outFile);

        Compressor zipCompressor = new Compressor(ZipOutputStream::new);
        zipCompressor.compress(inFile, outFile);
    }

}
