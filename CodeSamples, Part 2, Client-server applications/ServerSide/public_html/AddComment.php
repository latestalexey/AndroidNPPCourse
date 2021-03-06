<?php

require_once('api/ApiBlog.php');
require_once('api/DatabaseConstants.php');

$article_id = $user_id = $text = $password = $article_url = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $article_id = escape($_POST['article_id']);
    $user_id = escape($_SESSION['user_id']);
    $text = escape($_POST['text']);
    $password = escape($_SESSION['password']);
    $article_url = escape($_POST['article_url']);

    $blog = new ApiBlog();
    $params = json_decode('{}');
    $params->token = API_PASS;
    $params->article_id = $article_id;
    $params->user_id = $user_id;
    $params->text = $text;
    $params->password = $password;

    $result = $blog->addComment($params);

    if ($result->answer === DatabaseConstants::$ANSWER_OK) {
        //TODO : add comment to article dynamically - it's impossible with php only
        echo "<a href='".$article_url."'>Back to article</a>";
    }
    elseif ($result->answer === DatabaseConstants::$ANSWER_FAIL) {
        if ($result->error === DatabaseConstants::$ERROR_NO_SUCH_USER) {
            echo("You aren't authorized</br>");
            echo "<a href='".$article_url."'>Back to article</a>";
        }
        else if ($result->result === DatabaseConstants::$ERROR_PARAMS_TOKEN) {
            echo("Failed to add comment</br>");
            echo "<a href='".$article_url."'>Back to article</a>";
        }
    }
}

function escape($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}