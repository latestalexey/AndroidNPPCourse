<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Material design</title>
    <link rel="stylesheet" type="text/css" href="articles/material_design/styles.css">
</head>
<body>

<?php
    include('pages_header.php');
?>

<p>
    Мы разобрали философию Material Design в общем, но это пока не сильно помогает нам при разработке приложений. Пора
    исправить эту ситуацию и перейти к
    практике.
</p>

<p>
    Понятно, что в ближайшее время лишь малая часть Android-устройств будет работать под управлением версии Android 5.0
    и выше. Поэтому, для того, чтобы
    создать хороший интерфейс в соответствии с Material Design, необходимо использовать библиотеки поддержки, главной из
    которых является appcompat library.
    Эта библиотека позволяет, во-первых, легко использовать единый стиль для всех компонент приложения и делает все
    виджеты «более материальными», и во-вторых,
    улучшает ActionBar.
</p>

<pre style="background:#eee;color:#000">dependencies {
    compile <span style="color:#036a07">'com.android.support:appcompat-v7:21.0.+'</span>
}
</pre>

<p>
    Последние версии Android Studio автоматически добавляют эту библиотеку при создании проекта.
</p>
<p>
    Следующий шаг – определить стили, которое будет использовать наше приложение. Мы уже говорили, что стандартный ActionBar необходимо заменить на более
    гибкий Toolbar. Для примера создадим основной стиль приложения. Во-первых, нужно определить цветовую палитру приложения, то есть выбрать цвета
    colorPrimary, colorPrimaryDark и colorAccent. Создадим файл colors.xml:
</p>

<pre style="background:#eee;color:#000"><span style="color:#1c02ff">&lt;<span style="font-weight:700">resources</span>></span>
    <span style="color:#1c02ff">&lt;<span style="font-weight:700">color</span> <span style="font-style:italic">name</span>=<span style="color:#036a07">"color_primary"</span>></span><span style="color:#06f;font-style:italic">&lt;!-- your color here --></span><span style="color:#1c02ff">&lt;/<span style="font-weight:700">color</span>></span>
    <span style="color:#1c02ff">&lt;<span style="font-weight:700">color</span> <span style="font-style:italic">name</span>=<span style="color:#036a07">"color_primary_dark"</span>></span><span style="color:#06f;font-style:italic">&lt;!-- your color here --></span><span style="color:#1c02ff">&lt;/<span style="font-weight:700">color</span>></span>
    <span style="color:#1c02ff">&lt;<span style="font-weight:700">color</span> <span style="font-style:italic">name</span>=<span style="color:#036a07">"color_accent"</span>></span><span style="color:#06f;font-style:italic">&lt;!-- your color here --></span><span style="color:#1c02ff">&lt;/<span style="font-weight:700">color</span>></span>
<span style="color:#1c02ff">&lt;/<span style="font-weight:700">resources</span>></span>
</pre>

<?php

?>

</body>
</html>