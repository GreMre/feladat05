package com.example.feladat01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Vezerlo {
    // Dependency injection:
    @Autowired
    private SütiRepository sütiRepository;
    @Autowired
    private ÁrRepository árRepository;
    @Autowired
    private TartalomRepository tartalomRepository;



    @GetMapping("/products_list2")
    public String SütiAdatok(Model model) {
        String str = B();
        model.addAttribute("str", str);
        return "products";
    }

    String B() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<style>table {\n" + " border-collapse: collapse;\n" + "width: 100%;\n" + "}\n" +
                "\n" +"th, td {\n" +"border: 1px solid #dddddd;\n" +"text-align: left;\n" +"padding: 8px;\n" +
                "}\n" +"\n" +"th {\n" +"background-color: #f2f2f2;\n" +"}</style>");
        strBuilder.append("<table>");
        strBuilder.append("<tr><th>Név</th><th>Típus</th><th>Díjazott</th><th>Árak</th><th>Mentes</th></tr>");

        for (Süti süti : sütiRepository.findAll()) {
            strBuilder.append("<tr>");

            strBuilder.append("<td>").append(süti.getNév()).append("</td>");
            strBuilder.append("<td>").append(süti.getTípus()).append("</td>");

            if (süti.isDíjazott()) {
                strBuilder.append("<td>díjazott</td>");
            } else {
                strBuilder.append("<td>nem díjazott</td>");
            }

            List<Ár> árak = süti.getÁrak();
            if (árak != null && !árak.isEmpty()) {
                StringBuilder priceBuilder = new StringBuilder();
                for (int i = 0; i < árak.size(); i++) {
                    Ár aktuálisÁr = árak.get(i);
                    priceBuilder.append(aktuálisÁr.getEgység()).append(": ").append(aktuálisÁr.getÉrték());
                    if (i < árak.size() - 1) {
                        priceBuilder.append(", ");
                    }
                }
                strBuilder.append("<td>").append(priceBuilder.toString()).append("</td>");
            } else {
                strBuilder.append("<td></td>");
            }

            Tartalom tartalom = süti.getTartalom();
            if (tartalom != null) {
                String mentes = tartalom.getMentes();
                if (mentes != null) {
                    switch (mentes) {
                        case "G":
                            strBuilder.append("<td>Gluténmentes</td>");
                            break;
                        case "L":
                            strBuilder.append("<td>Laktózmentes</td>");
                            break;
                        case "HC":
                            strBuilder.append("<td>Cukormentes</td>");
                            break;
                        case "Te":
                            strBuilder.append("<td>Tejmentes</td>");
                            break;
                        case "To":
                            strBuilder.append("<td>Tojásmentes</td>");
                            break;
                        case "É":
                            strBuilder.append("<td>E-mentes</td>");
                            break;
                        default:
                            strBuilder.append("<td>Ismeretlen</td>");
                            break;
                    }
                }
            } else {
                strBuilder.append("<td>Nem mentes</td>");
            }


            strBuilder.append("</tr>");
        }

        strBuilder.append("</table>");
        return strBuilder.toString();
    }
}