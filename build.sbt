name := "isarn-collections"

organization := "org.isarnproject"

bintrayOrganization := Some("isarn")

version := "0.0.3"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8")

useGpg := true

pomIncludeRepository := { _ => false }

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

licenses += ("Apache-2.0", url("http://opensource.org/licenses/Apache-2.0"))

homepage := Some(url("https://github.com/isarn/isarn-collections"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/isarn/isarn-collections"),
    "scm:git@github.com:isarn/isarn-collections.git"
  )
)

developers := List(
  Developer(
    id    = "erikerlandson",
    name  = "Erik Erlandson",
    email = "eje@redhat.com",
    url   = url("https://erikerlandson.github.io/")
  )
)

def commonSettings = Seq(
  libraryDependencies ++= Seq(
    "org.isarnproject" %% "isarn-algebra-api" % "0.0.2",
    "org.isarnproject" %% "isarn-algebird-algebra-api" % "0.0.3" % Test,
    "org.isarnproject" %% "isarn-scalatest" % "0.0.2" % Test,
    "org.scalatest" %% "scalatest" % "2.2.4" % Test
  )
)

seq(commonSettings:_*)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

scalacOptions in (Compile, doc) ++= Seq("-doc-root-content", baseDirectory.value+"/root-doc.txt")

site.settings

site.includeScaladoc()

// enable to allow gh-pages via jekyll
// site.jekyllSupport()

ghpages.settings

git.remoteRepo := "git@github.com:isarn/isarn-collections.git"
