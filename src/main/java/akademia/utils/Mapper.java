package akademia.utils;

import org.springframework.stereotype.Component;

//Mapper parsuje z jednego na drugi

public interface Mapper <F, T>  {
    T map(F from); //mapujesz np. Hotel na DTO

    F reverse (T to );  // mapujesz
}
