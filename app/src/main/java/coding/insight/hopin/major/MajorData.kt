package coding.insight.hopin.major

import coding.insight.hopin.R

object MajorData {
    private val majorNames = arrayOf("Medicine",
        "Veterinary Medicine",
        "Computer Science",
        "Communications",
        "Business",
        "Economics",
    "Chemical Engineering")

    private val majorDetails = arrayOf("A program that focuses on the scientific study of the molecular and cellular basis of disease, and the application of this knowledge to the development of new clinical and diagnostic tools, medications, and therapies.",
        "A program that prepares individuals for the independent professional practice of veterinary medicine, involving the diagnosis, treatment, and health care management of animals and animal populations and the prevention and management of zoonosis.",
        "Is a major for problem solvers who want to learn how to use computers and computational processes to build websites, program robots, mine data and more. Computer science majors may go on to master's or doctorate programs in the field, and they can work in research and industry.",
        "Is the study of how to effectively communicate different types of information in various fields such as journalism/media, business, politics, and law.",
        "Business majors will study economics, accounting, management, marketing, finance, ethics and communications. Students in a business major learn fundamental business knowledge in accounting, international business, finance, marketing, project management, economics and more.",
        " is a degree option that examines questions related to resource allocation, incentives and wealth, among others. Economics is relevant to graduate and professional study in fields like business management, law and public affairs, as well as undergraduate degrees that are useful for many career paths.",
    "Chemical engineering majors learn to change raw materials into economically viable products. A college degree in chemical engineering can cut across a variety of academic paths, combining such subjects as chemistry, math, physics, engineering and biology.")

    private val majorImages = intArrayOf(R.drawable.medical,
        R.drawable.hewan,
        R.drawable.komputer,
        R.drawable.komunis,
        R.drawable.bisnis,
        R.drawable.ekonomi,
        R.drawable.teknik,)

    val listData: ArrayList<Major>
        get() {
            val list = arrayListOf<Major>()
            for (position in majorNames.indices) {
                val major = Major()
                major.name = majorNames[position]
                major.detail = majorDetails[position]
                major.photo = majorImages[position]
                list.add(major)
            }
            return list
        }
}