/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empire;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Thrawn
 */
public enum EnvironmentTypes {
    Mountainous,
    Flatlands,
    Forest,
    Budapest,
    Beach;
    
    public static List<String> getAllTypes(){
    List<String> enumNames = Stream.of(EnvironmentTypes.values())
                               .map(EnvironmentTypes::name)
                               .collect(Collectors.toList());
    return enumNames;
}
    
}
