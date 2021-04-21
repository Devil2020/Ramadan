package com.morse.ramadan.externsion

import android.app.Activity
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.morse.ramadan.model.DayItem


fun Activity.setUpWaveShape(fileName: String): ByteArray {
    return assets.open(fileName).readBytes()
}

private fun getRamadanDaysDefault(): String {
    return "[\n" +
            "  {\n" +
            "    \"dayNumber\": 1,\n" +
            "    \"dayNumberAr\": \"١\",\n" +
            "    \"dayPrayer\": \"اللهم اجعل صيامي فيه صيام الصادقين، وقيامي فيه قيام القانتين، ونبهني فيه عن نومة الغافلين، واغفر لي جرمي فيه يا إله العالمين، واعف عني يا عافيا عن المجرمين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day1.mp3\",\n" +
            "    \"dayAudioLength\": \"0.40\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 2,\n" +
            "    \"dayNumberAr\": \"٢\",\n" +
            "    \"dayPrayer\": \"اللهم اجعل صيامي فيه صيام الصادقين، وقيامي فيه قيام القانتين، ونبهني فيه عناللهم قربني فيه إلى مرضاتك، وجنبني فيه من سخطك ونقماتك، ووفقني فيه لقراءة آياتك، برحمتك يا أرحم الراحمين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day2.mp3\",\n" +
            "    \"dayAudioLength\": \"0.38\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 3,\n" +
            "    \"dayNumberAr\": \"٣\",\n" +
            "    \"dayPrayer\": \"اللهم ارزقني فيه الذهن والتنبيه، وباعدني فيه من السفاهة والتمويه، واجعل لي نصيبا من كل خير تنزل فيه، بجودك يا أجود الأجودين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day3.mp3\",\n" +
            "    \"dayAudioLength\": \"0.43\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 4,\n" +
            "    \"dayNumberAr\": \"٤\",\n" +
            "    \"dayPrayer\": \"اللهم قوني فيه على إقامة أمرك، وأذقني فيه حلاوة ذكرك، وأوزعني فيه لأداء شكرك بكرمك، واحفظني فيه بحفظك وسترك، يا أبصر الناظرين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day4.mp3\",\n" +
            "    \"dayAudioLength\": \"0.41\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 5,\n" +
            "    \"dayNumberAr\": \"٥\",\n" +
            "    \"dayPrayer\": \"اللهم اجعلني فيه من المستغفرين، واجعلني فيه من عبادك الصالحين القانتين، واجعلني فيه من أوليائك المقربين، برأفتك يا أرحم الراحمين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day5.mp3\",\n" +
            "    \"dayAudioLength\": \"0.43\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 6,\n" +
            "    \"dayNumberAr\": \"٦\",\n" +
            "    \"dayPrayer\": \"اللهم لا تخذلني فيه لتعرض معصيتك، ولا تضربني بسياط نقمتك، وزحزحني فيه من موجبات سخطك، بمنك وأياديك يا منتهى رغبة الراغبين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day6.mp3\",\n" +
            "    \"dayAudioLength\": \"0.48\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 7,\n" +
            "    \"dayNumberAr\": \"٧\",\n" +
            "    \"dayPrayer\": \"اللهم أعني فيه على صيامه وقيامه، وجنبني فيه من هفواته وآثامه، وارزقني فيه ذكرك بدوامه، بتوفيقك يا هادي المضلين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day7.mp3\",\n" +
            "    \"dayAudioLength\": \"0.42\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 8,\n" +
            "    \"dayNumberAr\": \"٨\",\n" +
            "    \"dayPrayer\": \"اللهم ارزقني فيه رحمة الأيتام، وإطعام الطعام، وإفشاء السلام، وصحبة الكرام، بطولك يا ملجأ الآملين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day8.mp3\",\n" +
            "    \"dayAudioLength\": \"0.50\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 9,\n" +
            "    \"dayNumberAr\": \"٩\",\n" +
            "    \"dayPrayer\": \"اللهم اجعل لي فيه نصيبا من رحمتك الواسعة، واهدني فيه لبراهينك الساطعة، وخذ بناصيتي إلى مرضاتك الجامعة، بمحبتك يا أمل المشتاقين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day9.mp3\",\n" +
            "    \"dayAudioLength\": \"0.45\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 10,\n" +
            "    \"dayNumberAr\": \"١٠\",\n" +
            "    \"dayPrayer\": \"اللهم اجعلني فيه من المتوكلين عليك، واجعلني فيه من الفائزين لديك، واجعلني فيه من المقربين إليك، بإحسانك يا غاية الطالبين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day10.mp3\",\n" +
            "    \"dayAudioLength\": \"0.40\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 11,\n" +
            "    \"dayNumberAr\": \"١١\",\n" +
            "    \"dayPrayer\": \"اللهم حبب إلى فيه الإحسان، وكره فيه الفسوق والعصيان، وحرم على فيه السخط والنيران، بعونك يا غياث المستغيثين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day11.mp3\",\n" +
            "    \"dayAudioLength\": \"0.43\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 12,\n" +
            "    \"dayNumberAr\": \"١٢\",\n" +
            "    \"dayPrayer\": \"اللهم زيني فيه بالستر والعفاف، واسترني فيه بلباس القنوع والكفاف، واحملني فيه على العدل والإنصاف، وآمني فيه من كل ما أخاف، بعصمتك يا عصمة الخائفين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day12.mp3\",\n" +
            "    \"dayAudioLength\": \"0.45\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 13,\n" +
            "    \"dayNumberAr\": \"١٣\",\n" +
            "    \"dayPrayer\": \"اللهم طهرني فيه من الدنس والأقذار، وصبرني فيه على كائنات الأقدار، ووفقني فيه للتقى وصحبة الأبرار، بعونك يا قرة عين المساكين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day13.mp3\",\n" +
            "    \"dayAudioLength\": \"0.46\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 14,\n" +
            "    \"dayNumberAr\": \"١٤\",\n" +
            "    \"dayPrayer\": \"اللهم لا تؤاخذني فيه بالعثرات، وأقلني فيه من الخطايا والهفوات، ولا تجعلني فيه غرضا للبلايا والآفات، بعزتك يا عز المسلمين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day14.mp3\",\n" +
            "    \"dayAudioLength\": \"0.46\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 15,\n" +
            "    \"dayNumberAr\": \"١٥\",\n" +
            "    \"dayPrayer\": \"اللهم ارزقني فيه طاعة الخاشعين، واشرح فيه صدري بإنابة المخبتين، بأمانك يا أمان الخائفين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day15.mp3\",\n" +
            "    \"dayAudioLength\": \"0.35\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 16,\n" +
            "    \"dayNumberAr\": \"١٦\",\n" +
            "    \"dayPrayer\": \"اللهم وفقني فيه لموافقة الأبرار، وجنبني فيه مرافقة الأشرار، وآوني فيه برحمتك إلى دار القرار، بإلهيتك يا إله العالمين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day16.mp3\",\n" +
            "    \"dayAudioLength\": \"0.46\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 17,\n" +
            "    \"dayNumberAr\": \"١٧\",\n" +
            "    \"dayPrayer\": \"اللهم اهدني فيه لصالح الأعمال، واقض لي فيه الحوائج والآمال، يا من لا يحتاج إلى التفسير والسؤال، يا عالما بما في صدور العالمين، صل على محمد وآله الطاهرين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day17.mp3\",\n" +
            "    \"dayAudioLength\": \"0.42\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 18,\n" +
            "    \"dayNumberAr\": \"١٨\",\n" +
            "    \"dayPrayer\": \"اللهم نبهني فيه لبركات أسحاره، ونور قلبي بضياء أنواره، وخذ بكل أعضائي إلى اتباع آثاره، بنورك يا منور قلوب العارفين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day18.mp3\",\n" +
            "    \"dayAudioLength\": \"0.46\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 19,\n" +
            "    \"dayNumberAr\": \"١٩\",\n" +
            "    \"dayPrayer\": \"اللهم وفر فيه حظي من بركاته، وسهل سبيلي إلى خيراته، ولا تحرمني قبول حسناته، يا هاديا إلى الحق المبين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day19.mp3\",\n" +
            "    \"dayAudioLength\": \"0.40\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 20,\n" +
            "    \"dayNumberAr\": \"٢٠\",\n" +
            "    \"dayPrayer\": \"اللهم افتح لي فيه أبواب الجنان، وأغلق عني فيه أبواب النيران، ووفقني فيه لتلاوة القرآن، يا منزل السكينة في قلوب المؤمنين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day20.mp3\",\n" +
            "    \"dayAudioLength\": \"0.44\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 21,\n" +
            "    \"dayNumberAr\": \"٢١\",\n" +
            "    \"dayPrayer\": \"اللهم اجعل لي فيه إلى مرضاتك دليلا، ولا تجعل للشيطان فيه على سبيلا، واجعل الجنة لي منزلا ومقيلا، يا قاضي حوائج الطالبين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day21.mp3\",\n" +
            "    \"dayAudioLength\": \"0.38\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 22,\n" +
            "    \"dayNumberAr\": \"٢٢\",\n" +
            "    \"dayPrayer\": \"اللهم افتح لي فيه أبواب فضلك، وأنزل على فيه بركاتك، ووفقني فيه لموجبات مرضاتك، وأسكني فيه بحبوحات جناتك، يا مجيب دعوة المضطرين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day22.mp3\",\n" +
            "    \"dayAudioLength\": \"0.56\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 23,\n" +
            "    \"dayNumberAr\": \"٢٣\",\n" +
            "    \"dayPrayer\": \"اللهم اغسلني فيه من الذنوب، وطهرني فيه من العيوب، وامتحن قلبي فيه بتقوى القلوب، يا مقيل عثرات المذنبين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day23.mp3\",\n" +
            "    \"dayAudioLength\": \"0.42\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 24,\n" +
            "    \"dayNumberAr\": \"٢٤\",\n" +
            "    \"dayPrayer\": \"اللهم إني أسألك فيه ما يرضيك، وأعوذ بك مما يؤذيك، وأسألك التوفيق فيه لأن أطيعك ولا أعصيك، يا جواد السائلين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day24.mp3\",\n" +
            "    \"dayAudioLength\": \"0.44\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 25,\n" +
            "    \"dayNumberAr\": \"٢٥\",\n" +
            "    \"dayPrayer\": \"اللهم اجعلني فيه محبا لأوليائك، ومعاديا لأعدائك، مستنا بسنة خاتم أنبيائك، يا عاصم قلوب النبيين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day25.mp3\",\n" +
            "    \"dayAudioLength\": \"0.39\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 26,\n" +
            "    \"dayNumberAr\": \"٢٦\",\n" +
            "    \"dayPrayer\": \"اللهم اجعل سعيي فيه مشكورا، وذنبي فيه مغفورا، وعملي فيه مقبولا، وعيبي فيه مستورا، يا أسمع السامعين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day26.mp3\",\n" +
            "    \"dayAudioLength\": \"0.44\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 27,\n" +
            "    \"dayNumberAr\": \"٢٧\",\n" +
            "    \"dayPrayer\": \"اللهم ارزقني فيه فضل ليلة القدر، وصير أموري فيه من العسر إلى اليسر، واقبل معاذيري وحط عني الذنب والوزر، يا رؤوفا بعباده الصالحين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day27.mp3\",\n" +
            "    \"dayAudioLength\": \"0.48\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 28,\n" +
            "    \"dayNumberAr\": \"٢٨\",\n" +
            "    \"dayPrayer\": \"اللهم وفر حظي فيه من النوافل، وأكرمني فيه بإحضار المسائل، وقرب فيه وسيلتي إليك من بين الوسائل، يا من لا يشغله إلحاح الملحين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day28.mp3\",\n" +
            "    \"dayAudioLength\": \"0.37\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 29,\n" +
            "    \"dayNumberAr\": \"٢٩\",\n" +
            "    \"dayPrayer\": \"اللهم غشني فيه بالرحمة، وارزقني فيه التوفيق والعصمة، وطهر قلبي من غياهب التهمة، يا رحيما بعباده المؤمنين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day29.mp3\",\n" +
            "    \"dayAudioLength\": \"0.40\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"dayNumber\": 30,\n" +
            "    \"dayNumberAr\": \"٣٠\",\n" +
            "    \"dayPrayer\": \"اللهم اجعل صيامي فيه بالشكر والقبول على ما ترضاه ويرضاه الرسول، محكمة فروعه بالأصول، بحق سيدنا محمد وآله الطاهرين، والحمد لله رب العالمين.\",\n" +
            "    \"dayAudio\": \"file:///android_asset/day30.mp3\",\n" +
            "    \"dayAudioLength\": \"0.40\"\n" +
            "  }\n" +
            "\n" +
            "]"
}

private fun getRamadanDaysString(activity: Activity): String {
    var daysJson = ""
    try {
        daysJson = activity.assets.open("ramadan.json").bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        return getRamadanDaysDefault()
    }
    return daysJson
}

fun Activity.getRamadanDaysArrayList(): ArrayList<DayItem> {
    val gson = GsonBuilder().create()
    val collectionType = object : TypeToken<Collection<DayItem?>?>() {}.type
    return gson.fromJson(getRamadanDaysString(this), collectionType)
}