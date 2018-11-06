SDK使用的一些说明，
Some instructions for using SDK,

这个SDK里的网络请求是用JAVA的API"HttpsURLConnection"写的，自己封装的一些网络请求，所以强烈建议使用第三方框架来调用我们的API
The network request in this SDK is written with JAVA API "HttpsURLConnection", some of its own network request package, it is recommended to use the third party framework to call our API


SDK里的几个类
Several classes in SDK

Response 这是一个网络请求的结果类，网络请求的结果封装在里面，包括返回的状态码和返回的信息
Response: This is a result of a class of network requests, the results of the network package is included in the request, including the return of the state code stuta and return information content


CommonOperate 封装了detect，compare，search这三个接口
CommonOperate: encapsulates the detect, compare, search these three interfaces


FaceSetOperate FaceSet相关的操作
FaceSetOperate:FaceSet related operations


FaceOperate Face相关的操作
FaceOperate:Face related operations

CardOperate 封装了证件识别的接口，使用国际版请忽视这个类
CardOperate: interface for document identification，please ignore if you are use international version

ImageOperate 图片识别接口的封装，使用国际版请忽视这个类
ImageOperate: image recognition interface package，please ignore if you are use international version

BodyOperate 封装了人体检测和人像扣图的功能
BodyOperate:HumanBody Detect and HumanBody Segment

HttpRequest 这里面封装了网络请求
HttpRequest: This is a network request

Key 这里面定义了一些字段
Key: here are some fields defined

具体的参数说明及方法功能请看每个方法的注释
Specific parameters and methods to see the function of each method notes