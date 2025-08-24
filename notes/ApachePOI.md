# Apache POI

[Resource](https://www.baeldung.com/java-microsoft-word-with-apache-poi)


Apache POI is a Java library for working with the various file formats based on the Office Open XML standards (OOXML) and Microsoft’s OLE 2 Compound Document format (OLE2).


Here’s a **Markdown (`.md`) notes draft** you can use for Apache POI:


## 📘 Apache POI Notes

Apache POI is a **Java library** for reading and writing Microsoft Office formats such as Excel, Word, and PowerPoint.


## 📂 Core Components
- **HSSF** → For Excel 97–2003 (`.xls`) (binary format).
- **XSSF** → For Excel 2007+ (`.xlsx`) (XML format).
- **SXSSF** → Streaming API for writing large `.xlsx` files (low memory footprint).
- **HWPF / XWPF** → For Word documents (`.doc` / `.docx`).
- **HSLF / XSLF** → For PowerPoint slides (`.ppt` / `.pptx`).

---

## 📊 Working with Excel

### Create Workbook

```java
// For small/moderate data (loads all in memory)
Workbook workbook = new XSSFWorkbook();

// For huge data export (streaming)
SXSSFWorkbook workbook = new SXSSFWorkbook(100); // keeps 100 rows in memory
````

### Create Sheet & Row

```java
Sheet sheet = workbook.createSheet("MySheet");
Row row = sheet.createRow(0);
Cell cell = row.createCell(0);
cell.setCellValue("Hello POI!");
```

### Write to File

```java
try (FileOutputStream fos = new FileOutputStream("output.xlsx")) {
    workbook.write(fos);
    workbook.close(); // VERY important to avoid memory leaks
}
```

---

## ⚡ XSSFWorkbook vs SXSSFWorkbook

| Feature    | XSSFWorkbook              | SXSSFWorkbook                                  |
| ---------- | ------------------------- | ---------------------------------------------- |
| Memory     | Loads full file in memory | Keeps only a window of rows (default 100)      |
| Speed      | Slower for large files    | Faster for large exports                       |
| File Size  | Same                      | Same                                           |
| Best Use   | Small to medium datasets  | Huge datasets (10,000+ rows)                   |
| Limitation | None                      | Cannot read, only write; limited random access |

---

## 🧮 Formula Evaluation

* Apache POI can **evaluate formulas** inside Excel files.

```java
FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
evaluator.evaluateAll(); // Pre-computes all formulas
```

⚠️ **Cons**: Memory & CPU heavy for large files.
✅ Excel will auto-recalculate formulas when opening the file, so this step can often be skipped.

---

## 🧹 Memory Management

* Always close resources:

    * `workbook.close()`
    * `inputStream.close()`
* Use **try-with-resources** for safety.
* For **SXSSFWorkbook**, call:

```java
workbook.dispose(); // Deletes temporary files on disk
```

---

## 🛠️ Common Issues

* **OOM (OutOfMemoryError)** → Caused by using `XSSFWorkbook` for huge data → switch to `SXSSFWorkbook`.
* **Large heap usage** → Not disposing workbooks, evaluators, or streams.
* **Formula performance** → Avoid `evaluator.evaluateAll()` for very large exports.

---

## ✅ Best Practices

* Use **SXSSFWorkbook** for large exports.
* Skip formula evaluation → let Excel handle it.
* Dispose workbooks properly to free memory/disk.
* Reuse cell styles (creating too many styles leads to performance issues).
* Protect sheets with `.protectSheet("password")` if needed.
* Lock/unlock formatting with:

```java
((XSSFSheet) sheet).lockFormatColumns(false);
```