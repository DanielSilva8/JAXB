import javax.xml.bind.*;
import java.io.File;

/*
https://github.com/DanielSilva8
*/

public class JAXB {

    private static JAXBContext createContext(Class objclass) throws JAXBException  {
        return JAXBContext.newInstance(objclass);
    }

    private static Unmarshaller createUnmarshaller(JAXBContext context) throws JAXBException  {
        return context.createUnmarshaller();
    }

    private static Marshaller createMarshaller(JAXBContext context) throws JAXBException  {
        return context.createMarshaller();
    }

    private static Marshaller formatMarshaller(Marshaller marshaller) throws PropertyException {
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }

    public static <T> T load(File file, Class<T> clazz) throws JAXBException {
        return clazz.cast(
                createUnmarshaller(
                        createContext(clazz)
                ).unmarshal(file));
    }

    public static void save(File file, Object object) throws JAXBException {
        formatMarshaller(
                createMarshaller(
                        createContext(object.getClass())
                )
        ).marshal(object, file);
    }
}
