package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject jsonOfSandwich = new JSONObject(json);

        Sandwich mSandwich = new Sandwich();

        JSONObject nameObject = jsonOfSandwich.getJSONObject("name");
        String mainName = nameObject.getString("mainName");
        mSandwich.setMainName(mainName);


        JSONArray knownAsObject = nameObject.getJSONArray("alsoKnownAs");
        List<String> knownAsList = new ArrayList<>() ;

        for (int j = 0; j < knownAsObject.length(); j++) {
            knownAsList.add(knownAsObject.getString(j));
        }
        mSandwich.setAlsoKnownAs(knownAsList);


        String placeOfOrigin = jsonOfSandwich.getString("placeOfOrigin");
        mSandwich.setPlaceOfOrigin(placeOfOrigin);

        String description = jsonOfSandwich.getString("description");
        mSandwich.setDescription(description);

        String image = jsonOfSandwich.getString("image");
        mSandwich.setImage(image);

        JSONArray jsonIngredientsJ = jsonOfSandwich.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<>() ;

        for (int j = 0; j < jsonIngredientsJ.length(); j++) {
            ingredients.add(jsonIngredientsJ.getString(j));
        }
        mSandwich.setIngredients(ingredients);


        return mSandwich;
    }
}
