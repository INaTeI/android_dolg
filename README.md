Никифоров Владимир ЦТЭ Б9123-09.03.03
GHIBLI-PEOPLE-MOD_A2_GRID

Jetpack Compose
Hilt (DI)
Retrofit (HTTP клиент)
Navigation Compose
MVVM архитектура

Используемое API
Studio Ghibli API

endpoints:
Получение списка персонажей:
GET https://ghibliapi.vercel.app/people
Получение одного персонажа:
GET https://ghibliapi.vercel.app/people/{id}

VariantCode отображается на главном экране приложения строкой

Особенности:
LazyVerticalGrid
Карточки (Card)
Обработка Loading / Error / Success состояний
од на экран деталей

в приложении
Главный экран:
VariantCode
Сетка персонажей
Имя
Пол
Возраст
Экран деталей:
Имя
Пол
Возраст
Описание персонажа

Проект построен по MVVM:
presentation (Compose UI + ViewModel)
domain (Repository + Model)
data (Retrofit API)
