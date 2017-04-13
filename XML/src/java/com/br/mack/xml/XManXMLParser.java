package com.br.mack.xml;

import com.br.mack.entity.Actor;
import com.br.mack.entity.Movie;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 1147106
 */
public class XManXMLParser {

    public static List<Movie> parseFile(File file) {
        List<Movie> movies = new ArrayList<>();
        String title;
        int year;
        String rated;
        String released;
        String runtime;
        String[] genres;
        String director;
        String writer;
        List<Actor> actors = new ArrayList();
        String plot;
        String language;
        String country;
        String awards;
        String poster;
        String metascore;
        float imdbRating;
        int imdbVotes;
        String imdbId;
        String type;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);

            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            System.out.println("RAIZ: " + root.getNodeName());

            NodeList moviesNL = root.getElementsByTagName("movie");
            for (int i = 0; i < moviesNL.getLength(); i++) {
                if (moviesNL.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element m = (Element) moviesNL.item(i);
                    
                    title = m.getAttribute("title");
                    year = Integer.parseInt(m.getAttribute("year"));
                    rated = m.getAttribute("rated");
                    released = m.getAttribute("released");
                    runtime = m.getAttribute("runtime");
                    genres = m.getAttribute("genre").split(", ");
                    director = m.getAttribute("director");
                    writer = m.getAttribute("writer");
                    
                    for(String actor:m.getAttribute("actor").split(", ")){
                        actors.add(new Actor(actor));
                    }
                    
                    plot = m.getAttribute("plot");
                    language = m.getAttribute("language");
                    country = m.getAttribute("country");
                    awards = m.getAttribute("awards");
                    poster = m.getAttribute("poster");
                    metascore = m.getAttribute("metascore");
                    imdbRating = Float.parseFloat(m.getAttribute("imdbRating"));
                    imgdbVoter = Integer.parseInt(m.getAttribute("imdbVotes").replaceAll(",", ""));
                    imdbId = m.getAttribute("imdbID");
                    type = m.getAttribute("type");
                    

                    Movie movie = new Movie(title, year, rated, released, runtime, genres, director, writer, actors, plot, language, country, awards, poster, metascore, imdbRating, imdbVotes, imdbId, type);

                    movies.add(movie);
                }

            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XManXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XManXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XManXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return movies;
    }
}
