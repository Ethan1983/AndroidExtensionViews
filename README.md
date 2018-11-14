# AndroidExtensionViews
Kotlin Android Extension usage with ViewStub

Views used to replace a ViewStub ( stubInflatedText of intro_text_layout.xml ) needs a Layout container. The container gets
the inflatedId (intro of main_fragment.xml) from the ViewStub. Without layoutcontainer, the textview replaces the ViewStub
but gets the inflatedId (intro) and the id stubInflatedText is basically ignored and any further findViewById will fail to
find the view.
