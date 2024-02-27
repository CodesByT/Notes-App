package com.example.notesapp.data

import com.example.notesapp.model.Note

var NotesData: List<Note> = mutableListOf(
    Note(
        title = "Note0",
        description = "What different data types are supported in this fake data generation tool? 15+ different types of data types are supported in this dummy data generator tool. Check the Field type selection above, some of them are Name, Email, Mobile number, Address, Sentences and a lot more."
    ),
    Note(
        title = "Note1",
        description = "Test data generator or fake data generator or dummy data generator is a useful tool to help you generate a lot of realistic fake data that you may not be able to get otherwise. For example, it can help you generate hundreds of user profile information or credit card data or weather data, fake address, and a lot more, or Free. This is great for getting data for testing purposes in your application. It is basically a dummy data generator built into a web page."
    ),
    Note(
        title = "Note2",
        description = "One of the most important tools for a software developer and a QA (quality analyst) is to be able to test their software with realistic fake data. It gives a better idea of how effective the software is, helps to identify bugs & issues, and load test the software with a large amount of data.So these dummy data generator tools give a large dataset that can be used for such purposes. Also the data can be used in train different models.It's a great way to get an idea of how different pieces of data will affect your application. The idea is that you canmake up some data and see how it will perform in different scenarios."
    ),
    Note(
        title = "Note3",
        description = "It is important that the test data generated should be real-looking data. This will help to perform any kind of simulation or testing with real data and not similar kinds of data. If your dataset is real like then the output will very effective"
    ),
    Note(
        title = "Note4",
        description = "This leads to some drawbacks - some models will not be satisfiable, and the generator will stop after a number of retries - but it also has many benefits when using the labels for validating clustering results. In particular when generating outlier detection data sets, you can easily avoid producing background noise within a dense cluster (which by definition would no longer be an outlier). When using this option, you should be aware of the risk of overfitting (but you should be aware of this when using artificial data anyway!)."
    ),
    Note(
        title = "Note5",
        description = "For a gold standard, the model specification serves a dual purpose: it is not only used to generate the points, but at the same time also to classify them. Only data points that classify as the same cluster they were generated for will be kept."
    ),
)

class NotesDataSource {
    fun LoadNotes(): List<Note> {
        return NotesData
    }
}