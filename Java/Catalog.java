package com.codewars.Java;

// You are given a small extract of a catalog:
//
// s = "<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>
//
// <prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>
//
// ...(prx stands for price, qty for quantity) and an article i.e "saw".
//
// The function catalog(s, "saw") returns the line(s) corresponding to the article with $ before the prices:
//
// "table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\n..."
//
// If the article is not in the catalog return "Nothing".
// Notes
//
//    There is a blank line between two lines of the catalog.
//    The same article may appear more than once. If that happens return all the lines concerned by the article (in the same order as in the catalog).
//    The line separator of results may depend on the language \nor \r\n. You can see examples in the "Sample tests".

public class Catalog {
    public static String returnCatalog(String s, String article) {

        // Directamente devolvemos "Nothing" si el articulo no esta
        if (!s.contains(article))
            return "Nothing";

        String resultado = "";

        String[] items = s.replace("", "")
                .replace("</name><prx>", "$")
                .replace("</prx><qty>", "#")
                .split("<prod><name>");

        for (String i : items)
            if (i.contains(article)) {
                String filtrado = i.substring(0, i.indexOf("$")) + " > prx: " + i.substring(i.indexOf("$"), i.indexOf("#")) + " qty: " + i.substring(i.indexOf("#")+1, i.indexOf("<"));
                resultado += (resultado.isEmpty()) ? filtrado : "\n" + filtrado;
            }
        return resultado;
    }
}

// Mejor solucion en CodeWars:
// public static String catalog(String s, String article) {
//    String xml = "<prods>" + s + "</prods>";
//    Prods prods = JAXB.unmarshal(new StringReader(xml), Prods.class);
//    DecimalFormat df = new DecimalFormat(".00");
//    String result = prods.prod.stream()
//      .filter(p -> p.name.contains(article))
//      .map(p -> String.format("%s > prx: $%s qty: %d",
//        p.name,
//        p.prx,
//        p.qty))
//      .collect(java.util.stream.Collectors.joining("\n"));
//    return result.isEmpty() ? "Nothing" : result;
//  }
//
//  static class Prods {
//    public LinkedList<Prod> prod = new LinkedList<>();
//  }
//
//  static class Prod {
//    public String name;
//    public String prx;
//    public int qty;
//  }
